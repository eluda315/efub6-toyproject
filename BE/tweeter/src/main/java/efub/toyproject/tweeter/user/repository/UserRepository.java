package efub.toyproject.tweeter.user.repository;

import efub.toyproject.tweeter.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

}
