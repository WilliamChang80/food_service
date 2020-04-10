package com.food.service.demo.service;

import com.food.service.demo.domain.Food;
import com.food.service.demo.domain.Store;

import java.util.List;

public interface StoreService {
    public List<Store> getAllStores();
    public Store getStoreByID(Long storeID);
    public List<Food> getAllFoodInStore(Store store);
    public void createStore(Store store);
    public void updateStore(Store store, Long storeID);
    public void deleteStore(Long storeID);
}
