package samt.loraterra.data;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samt.loraterra.domain.User;

import java.util.List;
import java.util.Optional;
/*questo è fatto da me però raffinato con AI*/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /* only one query runs to fetch both the post and its author.
     Without it, multiple queries are executed —
     one for the posts and one for each author —
     which is the N+1 problem.*/
    /*
    * -- 1. users (the role table is joined only for the WHERE condition)
    select u.id, u.email, u.name, u.password, u.role_id, u.surname
    from "users" u
    join role r on r.id = u.role_id
    where r.name <> ?;
    -- 2. later, when you call user.getRole().getName(), one query per distinct role
    select r.id, r.name from role r where r.id = ?;*/
    @EntityGraph(attributePaths = "role")
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    @EntityGraph(attributePaths = "role")
    List<User> findByRoleNameNot(String roleName);
}