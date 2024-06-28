package library.com.LibraryApp.repositories;

import library.com.LibraryApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
