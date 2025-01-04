package models

import org.jetbrains.exposed.dao.id.IntIdTable

object Authors : IntIdTable() {
    val name = varchar("name", 255)
}

data class Author(
    val id: Int,
    val name: String
)