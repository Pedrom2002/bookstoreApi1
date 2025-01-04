package services

import models.Genre
import models.Genres
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class GenreService {

    fun addGenre(genre: Genre): Genre {
        Genres.insert {
            it[name] = genre.name
        }
        return genre
    }

    fun getAllGenres(): List<Genre> {
        return Genres.selectAll().map {
            Genre(
                id = it[Genres.id].value,
                name = it[Genres.name]
            )
        }
    }

    fun getGenreById(id: Int): Genre? {
        return Genres.selectAll().where { Genres.id eq id }.map {
            Genre(
                id = it[Genres.id].value,
                name = it[Genres.name]
            )
        }.singleOrNull()
    }

    fun updateGenre(genre: Genre) {
        Genres.update({ Genres.id eq genre.id }) {
            it[name] = genre.name
        }
    }

    fun deleteGenre(id: Int) {
        Genres.deleteWhere { Genres.id eq id }
    }
}