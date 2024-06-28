package library.com.LibraryApp.repositories;

import library.com.LibraryApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
