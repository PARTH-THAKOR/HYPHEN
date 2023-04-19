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

    Iterable<HyphenUser> findByProjectNameAndChatIdOrderByTimeAsc(String projectName, String chatId);

    Iterable<HyphenUser> findByProjectNameAndChatIdOrderByTimeDesc(String projectName, String chatId);

    Iterable<HyphenUser> findByProjectNameOrderByTimeAsc(String projectName);

    @Transactional
    void deleteByProjectName(String deleteId);

    @Transactional
    void deleteByProjectNameAndDeleteId(String projectName, String deleteId);

    @Transactional
    void deleteByProjectNameAndSendId(String projectName, String sendId);

    @Transactional
    void deleteByProjectNameAndChatId(String projectName, String chatId);

}
