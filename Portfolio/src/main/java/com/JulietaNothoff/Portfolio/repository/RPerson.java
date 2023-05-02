
package com.JulietaNothoff.Portfolio.repository;

import com.JulietaNothoff.Portfolio.entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author julie
 */
public interface RPerson extends JpaRepository<Person, Integer>{
    public Optional<Person> findByFullname(String fullname);
    public boolean existsByFullname(String fullname);
}
