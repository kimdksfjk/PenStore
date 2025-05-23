package com.example.penstore.service.impl;

import com.example.penstore.common.CommonResponse;
import com.example.penstore.dao.GoodsMapper;
import com.example.penstore.entity.Goods;
import com.example.penstore.dto.GoodsRequest;
import com.example.penstore.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> getByCategory(String categoryId) {
        List<Goods> goodsList = goodsMapper.getByCategory(categoryId);
        return goodsList;
    }

    public Goods getById(String id) {
        Goods goods = goodsMapper.getById(id);
        return goods;
    }

    public List<Goods> getByInput(String query) {
        return goodsMapper.getByInput(query);
    }

    public List<Goods> searchProducts(String query) {
        return goodsMapper.searchProducts(query);
    }
    public List<Goods> getProductsWithCartQuantities(String[] productIds) {
        // 调用Mapper获取商品信息
        return goodsMapper.getProductsByIds(productIds);
    }
    public void insertGoods(GoodsRequest goodsRequest) {
        goodsMapper.insertGoods(goodsRequest);
    }
    //根据店铺id获取商品
    public List<Goods> getGoodsByShopId(String shop_id) {
        return goodsMapper.getGoodsByShopId(shop_id);
    }
    //根据查询条件获取商品
    public List<Goods> getGoodsByQuery(GoodsRequest goodsRequest) {
        return goodsMapper.getGoodsByQuery(goodsRequest);
    }
    //根据状态获取商品
    public List<Goods> getGoodsByStatus(String status, String shop_id) {
        return goodsMapper.getGoodsByStatus(status, shop_id);
    }
    public void updateGoods(String id,String operation, String shop_id) {
        if(operation.equals("delete")) {
            goodsMapper.deleteGoods(id, shop_id);
        }
        else if(operation.equals("available")) {
            goodsMapper.GoodsAvailable(id, shop_id);
        }
        else {
            goodsMapper.GoodsUnsold(id, shop_id);
        }
    }
    public void newGoods(GoodsRequest goodsRequest) {
        goodsMapper.updateGoods(goodsRequest);
    }
    public void updateStock(String id, int stock) {
        goodsMapper.updateStock(id, stock);
    }
}
