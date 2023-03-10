package com.skillbox.project.service.serviceImpl;

import com.skillbox.project.config.Site;
import com.skillbox.project.config.SitesList;
import com.skillbox.project.models.Status;
import com.skillbox.project.repository.PageRepository;
import com.skillbox.project.repository.SiteRepository;
import com.skillbox.project.service.StatisticsService;
import com.skillbox.project.statistics.DetailedStatisticsItem;
import com.skillbox.project.statistics.StatisticsData;
import com.skillbox.project.statistics.StatisticsResponse;
import com.skillbox.project.statistics.TotalStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private PageRepository pageRepository;

    private final Random random = new Random();
    private final SitesList sites;

    @Override
    public StatisticsResponse getStatistics() {
        String[] statuses = { "INDEXED", "FAILED", "INDEXING" };
        String[] errors = {
                "Ошибка индексации: главная страница сайта не доступна",
                "Ошибка индексации: сайт не доступен",
                ""
        };

        TotalStatistics total = new TotalStatistics();
        total.setSites(sites.getSites().size());
        total.setIndexing(true);

        List<DetailedStatisticsItem> detailed = new ArrayList<>();
        List<Site> sitesList = sites.getSites();
        for(int i = 0; i < sitesList.size(); i++) {
            Site site = sitesList.get(i);
            DetailedStatisticsItem item = new DetailedStatisticsItem();
            item.setName(site.getName());
            item.setUrl(site.getUrl());
            int pages = random.nextInt(1_000);
            int lemmas = pages * random.nextInt(1_000);
            item.setPages(pages);
            item.setLemmas(lemmas);
            item.setStatus(statuses[i % 3]);
            item.setError(errors[i % 3]);
            item.setStatusTime(System.currentTimeMillis() -
                    (random.nextInt(10_000)));
            total.setPages(total.getPages() + pages);
            total.setLemmas(total.getLemmas() + lemmas);
            detailed.add(item);
        }

        StatisticsResponse response = new StatisticsResponse();
        StatisticsData data = new StatisticsData();
        data.setTotal(total);
        data.setDetailed(detailed);
        response.setStatistics(data);
        response.setResult(true);
        return response;
    }

    @Override
    public void indexing() {
        for(Site s:sites.getSites()){
            com.skillbox.project.models.Site siteEntity = new com.skillbox.project.models.Site();
            siteEntity.setNameSite(s.getName());
            siteEntity.setUrl(s.getUrl());
            siteRepository.DeleteSiteByURL(s.getUrl());
            pageRepository.DeletePagesBySiteId(siteEntity.getId());
            siteEntity.setStatus(Status.INDEXING);
            // TODO: написать обход всех страниц с добавлением в бд, прописать контроллер



        }
    }
}