package efub.toyproject.tweeter.tweet.repository;

import efub.toyproject.tweeter.tweet.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
