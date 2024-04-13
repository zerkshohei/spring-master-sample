package com.zerk.spring.memo.orderitem;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderItemUseCase {
    public Item getDummy() {
        String s = "aaa";
        return new Item("test", new BigDecimal(12));
    }

    private Item getItemFrom() {
        return new Item("aaaaa", new BigDecimal(100));
    }

    public void showItem() {
        Item item = getItemFrom();
        System.out.println(item.getName());
    }
}
