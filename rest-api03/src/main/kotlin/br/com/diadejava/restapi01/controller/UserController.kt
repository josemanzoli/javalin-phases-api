package br.com.diadejava.restapi01.controller

import io.javalin.http.Context
import org.apache.logging.log4j.LogManager

class UserController{

    private val logger = LogManager.getLogger(UserController::class.java)

    fun create(context: Context) {
        logger.info("Creating user")
        context.json("Create User")
    }

    fun getAll(context: Context) {
        logger.info("Getting all users")
        context.json("Get All Users")
    }
}