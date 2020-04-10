package com.food.service.demo.service.impl;

import com.food.service.demo.domain.Food;
import com.food.service.demo.domain.Store;
import com.food.service.demo.repository.StoreRepository;
import com.food.service.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public List<Store> getAllStores() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }

    @Override
    public Store getStoreByID(Long storeID) {
        Store store = storeRepository.findById(storeID).orElse(null);
        return store;
    }

    @Override
    public List<Food> getAllFoodInStore(Store store) {
        Long storeID = store.getID();
        List<Food> foodList = store.getFood();
        return foodList;
    }

    @Override
    public void createStore(Store store) {
        storeRepository.save(store);
    }

    @Override
    public void updateStore(Store store, Long storeID) {
        Store udaptedStore = getStoreByID(storeID);
        udaptedStore.setFood(store.getFood())
                .setStoreAddress(store.getStoreAddress())
                .setStoreName(store.getStoreName());
    }

    @Override
    public void deleteStore(Long storeID) {
        Store deletedStore = getStoreByID(storeID);
        storeRepository.delete(deletedStore);
    }
}
