package services

import models.Book
import models.Books
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class BookService {

    fun addBook(book: Book): Book {

        Books.insert {
            it[title] = book.title
            it[authorId] = book.authorId
            it[genreId] = book.genreId
        }
        return book
    }

    fun getAllBooks(): List<Book> {
        return Books.selectAll().map {
            Book(
                id = it[Books.id].value,
                title = it[Books.title],
                authorId = it[Books.authorId],
                genreId = it[Books.genreId]
            )
        }
    }

    fun getBookById(id: Int): Book? {
        return Books.selectAll().where { Books.id eq id }.map {
            Book(
                id = it[Books.id].value,
                title = it[Books.title],
                authorId = it[Books.authorId],
                genreId = it[Books.genreId]
            )
        }.singleOrNull()
    }

    fun updateBook(book: Book) {
        Books.update({ Books.id eq book.id }) {
            it[title] = book.title
            it[authorId] = book.authorId
            it[genreId] = book.genreId
        }
    }

    fun deleteBook(id: Int) {
        Books.deleteWhere { Books.id eq id }
    }
}