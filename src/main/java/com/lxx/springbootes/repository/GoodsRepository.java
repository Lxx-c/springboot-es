package com.lxx.springbootes.repository;

import com.lxx.springbootes.entity.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author lxx
 */
public interface GoodsRepository extends ElasticsearchCrudRepository<GoodsInfo, Long> {
}
