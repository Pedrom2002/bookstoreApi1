package models

import org.jetbrains.exposed.dao.id.IntIdTable

object Genres : IntIdTable() {
    val name = varchar("name", 255)
}

data class Genre(
    val id: Int,
    val name: String
)