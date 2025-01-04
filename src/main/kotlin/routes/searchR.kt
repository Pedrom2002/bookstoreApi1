package routes

import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.searchRouting() {
    get("/search") {
        val query = call.request.queryParameters["query"]

        call.respondText("Buscar livros com : $query")
    }
}