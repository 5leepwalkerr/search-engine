package com.skillbox.project.repository;

import com.skillbox.project.models.Page;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PageRepository extends JpaRepository<Long, Page> {

    @Transactional
    @Query("delete from Page p where p.site=:siteId")
    @Modifying
    void DeletePagesBySiteId(Long siteId);

}
