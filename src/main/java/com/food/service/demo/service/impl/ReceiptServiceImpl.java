package com.food.service.demo.service.impl;

import com.food.service.demo.domain.Food;
import com.food.service.demo.domain.Receipt;
import com.food.service.demo.domain.Store;
import com.food.service.demo.domain.User;
import com.food.service.demo.repository.ReceiptRepository;
import com.food.service.demo.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    ReceiptRepository receiptRepository;

    @Override
    public List<Receipt> getAllReceipts() {
        List<Receipt> receiptList = receiptRepository.findAll();
        return receiptList;
    }

    @Override
    public void createReceipt(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Override
    public void updateReceipt(Receipt receipt, Long receiptID) {
        Receipt updatedReceipt = getReceiptByID(receiptID)
                .setReceiptDate(receipt.getReceiptDate())
                .setReceiptPrice(receipt.getReceiptPrice())
                .setReceiptStatus(receipt.getReceiptStatus())
                .setFood(receipt.getFood())
                .setStore(receipt.getStore())
                .setUser(receipt.getUser());
        receiptRepository.save(updatedReceipt);
    }

    @Override
    public void deleteReceipt(Long receiptID) {
        Receipt deletedReceipt = getReceiptByID(receiptID);
        receiptRepository.delete(deletedReceipt);
    }

    @Override
    public List<Food> getAllFoodInReceipt(Receipt receipt) {
        List<Food> food = receipt.getFood();
        return food;
    }

    @Override
    public User getUserInReceipt(Receipt receipt) {
        User user = receipt.getUser();
        return user;
    }

    @Override
    public Store getStoreInReceipt(Receipt receipt) {
        Store store = receipt.getStore();
        return store;
    }

    @Override
    public Receipt getReceiptByID(Long receiptID) {
        Receipt receipt = receiptRepository.findById(receiptID).orElse(null);
        return receipt;
    }
}
