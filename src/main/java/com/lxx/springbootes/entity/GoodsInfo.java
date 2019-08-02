package com.lxx.springbootes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author lxx
 */
@Data
@Document(indexName = "testgoods", type = "goods")
public class GoodsInfo implements Serializable {
    @Id
    private Long id;

    private String name;

    private String description;
}
