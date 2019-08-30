package br.com.diadejava.restapi01.application

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import br.com.diadejava.restapi01.controller.UserController

fun main(){

    val userController = UserController()

    val app = Javalin.create { config ->
        config.defaultContentType = "application/json"
    }.apply {
        routes {
            path("users") {
                get(userController::getAll)
                post(userController::create)
            }
        }
    }.start(7000)
}