package routes

import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.Genre

fun Route.genreRouting() {
    route("/genres") {
        get {
            call.respondText("Retornando todos os gêneros")
        }

        post {
            // Lógica para adicionar um novo gênero
            val genre = call.receive<Genre>()
            call.respondText("Gênero adicionado: ${genre.name}")
        }


    }
}