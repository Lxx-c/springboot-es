package com.lxx.springbootes.rest.controller;

import com.lxx.springbootes.entity.GoodsInfo;
import com.lxx.springbootes.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author lxx
 */
@RestController
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @PostMapping("/goods")
    public GoodsInfo save(@RequestBody GoodsInfo goodsInfo) {
        return goodsService.save(goodsInfo);
    }

    @DeleteMapping("/goods/{id}")
    public void delete(@PathVariable Long id) {
        goodsService.delete(id);
    }

    @PutMapping("/goods")
    public GoodsInfo update(@RequestBody GoodsInfo goodsInfo) {
        return goodsService.update(goodsInfo);
    }

    @GetMapping("/goods/{id}")
    public GoodsInfo get(@PathVariable Long id) {
        return goodsService.get(id);
    }

    @GetMapping("/goods")
    public Page<GoodsInfo> getAll(Integer id,Pageable pageable) {
        return goodsService.getAll(id,pageable);
    }

}
