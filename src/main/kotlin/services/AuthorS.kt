package services

import models.Author
import models.Authors
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class AuthorService {

    fun addAuthor(author: Author): Author {
        // Lógica para adicionar um autor ao banco de dados
        Authors.insert {
            it[name] = author.name
        }
        return author
    }

    fun getAllAuthors(): List<Author> {
        return Authors.selectAll().map {
            Author(
                id = it[Authors.id].value,
                name = it[Authors.name]
            )
        }
    }

    fun getAuthorById(id: Int): Author? {
        return Authors.selectAll().where { Authors.id eq id }.map {
            Author(
                id = it[Authors.id].value,
                name = it[Authors.name]
            )
        }.singleOrNull()
    }

    fun updateAuthor(author: Author) {
        Authors.update({ Authors.id eq author.id }) {
            it[name] = author.name
        }
    }

    fun deleteAuthor(id: Int) {
        Authors.deleteWhere { Authors.id eq id }
    }
}