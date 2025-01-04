
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import routes.*

fun main() {
    embeddedServer(Netty, port = 8082) {
        install(ContentNegotiation) {
            json()
        }
        routing {

            bookRouting()
            authorRouting()
            genreRouting()
            searchRouting()
            wishlistRouting()
        }
    }.start(wait = true)
}