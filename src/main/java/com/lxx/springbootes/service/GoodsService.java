package com.lxx.springbootes.service;

import com.lxx.springbootes.entity.GoodsInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lxx
 */
public interface GoodsService {

    GoodsInfo save(GoodsInfo goodsInfo);

    void delete(Long id);

    GoodsInfo update(GoodsInfo goodsInfo);

    GoodsInfo get(Long id);

    Page<GoodsInfo> getAll(Integer id, Pageable pageable);
}
