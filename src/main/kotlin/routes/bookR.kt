package routes

import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.Book


fun Route.bookRouting() {
    route("/books") {
        get {
            call.respondText("Retornar todos os livros")
        }

        post {

            val book = call.receive<Book>()
            call.respondText("Livro adicionado: ${book.title}")
        }

        route("/{id}") {
            get {

                val id = call.parameters["id"]
                call.respondText("Retornar livro com ID: $id")
            }

            put {
                val id = call.parameters["id"]
                val book = call.receive<Book>()
                call.respondText("Livro atualizado: ${book.title} com ID: $id")
            }

            delete {
                val id = call.parameters["id"]
                call.respondText("Livro removido com ID: $id")
            }
        }
    }
}