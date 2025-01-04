package routes

import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.Book
import models.Wishlist

fun Route.wishlistRouting() {
    route("/wishlists") {
        post {
            val wishlist = call.receive<Wishlist>()
            call.respondText("Lista de desejos criada para : ${wishlist.userId}")
        }

        route("/{id}") {
            get {
                val id = call.parameters["id"]
                call.respondText("Retornar livros na lista de desejos ID: $id")
            }

            post("/books") {
                val id = call.parameters["id"]
                val book = call.receive<Book>()
                call.respondText("Adicionar livro ${book.title} à lista de desejos ID: $id")
            }
        }
    }
}