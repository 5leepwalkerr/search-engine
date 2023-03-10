package com.skillbox.project.repository;

import com.skillbox.project.models.Site;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SiteRepository extends JpaRepository<Long, Site> {

    @Transactional
    @Query("select s from Site s where s.nameSite=:nameSite")
    Site siteWithExistName(String name);

    @Transactional
    @Query("delete from Site s where s.url =: url")
    @Modifying
    void DeleteSiteByURL(String url);


}
