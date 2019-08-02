package com.lxx.springbootes.service;

import com.lxx.springbootes.entity.GoodsInfo;
import com.lxx.springbootes.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author lxx
 */
@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;

    private final ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public GoodsInfo save(GoodsInfo goodsInfo) {
        return goodsRepository.save(goodsInfo);
    }

    @Override
    public void delete(Long id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public GoodsInfo update(GoodsInfo goodsInfo) {
        Optional<GoodsInfo> goodsInfoOptional = goodsRepository.findById(goodsInfo.getId());
        goodsInfoOptional.ifPresent(goods -> {
            goodsRepository.save(goodsInfo);
        });
        return goodsInfo;
    }

    @Override
    public GoodsInfo get(Long id) {
        return goodsRepository.findById(id).orElse(null);
    }

    @Override
    public Page<GoodsInfo> getAll(Integer id, Pageable pageable) {
        NativeSearchQueryBuilder query = new NativeSearchQueryBuilder().withPageable(pageable);
        if (!StringUtils.isEmpty(id)) {
            query.withQuery(QueryBuilders.matchQuery("id", id));
        }
        SearchQuery buildQuery = query.build();
        List<GoodsInfo> goodsInfos = elasticsearchTemplate.queryForList(buildQuery, GoodsInfo.class);
        return new PageImpl<>(goodsInfos);
    }

}
