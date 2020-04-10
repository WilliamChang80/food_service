package com.food.service.demo.service;

import com.food.service.demo.domain.Food;
import com.food.service.demo.domain.Receipt;
import com.food.service.demo.domain.Store;
import com.food.service.demo.domain.User;

import java.util.List;

public interface ReceiptService {
    public List<Receipt> getAllReceipts();
    public void createReceipt(Receipt receipt);
    public void updateReceipt(Receipt receipt, Long receiptID);
    public void deleteReceipt(Long receiptID);
    public Receipt getReceiptByID(Long receiptID);
    public List<Food> getAllFoodInReceipt(Receipt receipt);
    public User getUserInReceipt(Receipt receipt);
    public Store getStoreInReceipt(Receipt receipt);
}
