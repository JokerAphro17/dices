package  com.game.dice.repositories;

 import  com.game.dice.models.User;
 import  org.springframework.data.jpa.repository.JpaRepository;
 import  org.springframework.stereotype.Repository;
 import java.util.List;
 import java.util.Optional;

@Repository
 public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
    User save(User user);
    Optional<User> findById(Integer id);
    User findByEmail(String email);

    void delete(User user);





}