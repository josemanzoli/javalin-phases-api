package br.com.diadejava.restapi01.controller

import io.javalin.http.Context

class UserController{

    fun create(context: Context) {
        context.json("Create User")
    }

    fun getAll(context: Context) {
        context.json("Get All Users")
    }
}