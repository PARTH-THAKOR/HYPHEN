// MYSQL DataBaseMethods Repository

package org.rorb.dev.hyphen.repository;

import jakarta.transaction.Transactional;
import org.rorb.dev.hyphen.entity.HyphenUser;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@EnableJpaRepositories
@Service
public interface DataBaseMethods extends CrudRepository<HyphenUser, Integer> {

    Iterable<HyphenUser> findByChatIdOrderByTimeAsc(String chatId);

    Iterable<HyphenUser> findByChatIdOrderByTimeDesc(String chatId);

    @Transactional
    void deleteByDeleteId(String deleteId);

    @Transactional
    void deleteBySendId(String sendId);

    @Transactional
    void deleteByChatId(String chatId);

}
