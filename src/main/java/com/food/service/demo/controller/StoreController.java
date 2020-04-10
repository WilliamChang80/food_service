package com.food.service.demo.controller;

import com.food.service.demo.domain.Food;
import com.food.service.demo.domain.Store;
import com.food.service.demo.domain.base.BaseDto;
import com.food.service.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<BaseDto> getAllStores() {
        List<Store> storeList = storeService.getAllStores();
        return ResponseEntity.ok(new BaseDto(storeList, true, 200));
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<BaseDto> createStore(@RequestBody Store store) {
        storeService.createStore(store);
        return ResponseEntity.ok(new BaseDto(store, true, 200));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{storeID}")
    ResponseEntity<BaseDto> getStoreByID(@PathVariable Long storeID) {
        Store store = storeService.getStoreByID(storeID);
        return ResponseEntity.ok(new BaseDto(store, true, 200));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{storeID}")
    ResponseEntity<BaseDto> updateStore(@RequestBody Store store, @PathVariable Long storeID) {
        storeService.updateStore(store, storeID);
        return ResponseEntity.ok(new BaseDto(store, true, 200));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{storeID}")
    ResponseEntity<BaseDto> deleteStore(@PathVariable Long storeID) {
        storeService.deleteStore(storeID);
        return ResponseEntity.ok(new BaseDto("Store hass been deleted", true, 200));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{storeID}/food")
    ResponseEntity<BaseDto> getAllFoodInStore(@PathVariable Long storeID) {
        Store targetStore = storeService.getStoreByID(storeID);
        List<Food> foodList = storeService.getAllFoodInStore(targetStore);
        return ResponseEntity.ok(new BaseDto(foodList,true,200));
    }
}
