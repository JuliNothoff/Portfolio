
package com.JulietaNothoff.Portfolio.repository;

import com.JulietaNothoff.Portfolio.entity.Hys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julie
 */
@Repository
public interface RHys extends JpaRepository<Hys, Integer>{
    
}
