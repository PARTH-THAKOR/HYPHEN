// MYSQL DataBaseMethods Repository

package org.rorb.dev.hyphen.repository;

import org.rorb.dev.hyphen.entity.HyphenUser;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@EnableJpaRepositories
@Service
public interface DataBaseMethods extends CrudRepository<HyphenUser,Integer> {

}

