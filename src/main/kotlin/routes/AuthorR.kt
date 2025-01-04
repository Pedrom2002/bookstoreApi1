package routes

import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.Author


fun Route.authorRouting() {
    route("/authors") {
        get {
            call.respondText("Retornar todos os autores")
        }

        post {
            val author = call.receive<Author>()
            call.respondText("Autor adicionado: ${author.name}")
        }

        route("/{id}") {
            get {
                val id = call.parameters["id"]
                call.respondText("Retornar autor com ID: $id")
            }

            put {
                val id = call.parameters["id"]
                val author = call.receive<Author>()
                call.respondText("Autor atualizado: ${author.name} com ID: $id")
            }

            delete {
                val id = call.parameters["id"]
                call.respondText("Autor removido com ID: $id")
            }
        }
    }
}