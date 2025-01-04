package models

import org.jetbrains.exposed.dao.id.IntIdTable

object Wishlists : IntIdTable() {
    val userId = integer("user_id")
}

data class Wishlist(
    val id: Int,
    val userId: Int
)