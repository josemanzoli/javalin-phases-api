package br.com.diadejava.restapi01.koin

import br.com.diadejava.restapi01.controller.UserController
import org.koin.dsl.module

val userModule = module {
    single { UserController() }
}