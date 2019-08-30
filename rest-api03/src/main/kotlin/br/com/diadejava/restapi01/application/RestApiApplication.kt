package br.com.diadejava.restapi01.application

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import br.com.diadejava.restapi01.controller.UserController
import br.com.diadejava.restapi01.koin.userModule
import com.fasterxml.jackson.databind.ObjectMapper
import io.javalin.plugin.json.JavalinJackson
import org.eclipse.jetty.http.HttpStatus
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.context.startKoin

class RestApiApplication: KoinComponent{

    private val userController by inject<UserController>()

    fun startJavalin() {
        Javalin.create { config ->
            config.defaultContentType = "application/json"
            JavalinJackson.configure(ObjectMapper())
        }.apply {
            exception(Exception::class.java) { exception, ctx ->  exception.printStackTrace() }
            error(HttpStatus.NOT_FOUND_404) { ctx ->  ctx.json("not found") }
            routes {
                path("users") {
                    get(userController::getAll)
                    post(userController::create)
                }
            }
        }.start(7000)
    }
}

fun main(){
    startKoin {
        modules(userModule)
    }
    RestApiApplication().startJavalin()
}