package models

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date
import org.jetbrains.exposed.dao.id.IntIdTable

object Books : IntIdTable() {
    val title = varchar("title", 255)
    val authorId = integer("author_id")
    val genreId = integer("genre_id")
}

data class Book(
    val id: Int,
    val title: String,
    val authorId: Int,
    val genreId: Int
)