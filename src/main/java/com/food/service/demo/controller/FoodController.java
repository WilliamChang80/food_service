package com.food.service.demo.controller;

import com.food.service.demo.domain.Food;
import com.food.service.demo.domain.base.BaseDto;
import com.food.service.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<BaseDto> getAllFoods() {
        List<Food> foodList = foodService.getAllFoods();
        return ResponseEntity.ok(new BaseDto(foodList, true, 200));
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<BaseDto> createFood(@RequestBody Food food) {
        foodService.createFood(food);
        return ResponseEntity.ok(new BaseDto(food, true, 200));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{foodID}")
    ResponseEntity<BaseDto> updateFood(@RequestBody Food food, @PathVariable Long foodID) {
        foodService.updateFood(food, foodID);
        return ResponseEntity.ok(new BaseDto(food, true, 200));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{foodID}")
    ResponseEntity<BaseDto> deleteFood(@PathVariable Long foodID) {
        foodService.deleteFood(foodID);
        return ResponseEntity.ok(new BaseDto("Food has been deleted", true, 200));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{foodID}")
    ResponseEntity<BaseDto> getFoodByID(@PathVariable Long foodID) {
        Food food = foodService.getFoodByID(foodID);
        return ResponseEntity.ok(new BaseDto(food, true, 200));
    }

}
