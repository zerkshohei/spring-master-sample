package com.zerk.spring.memo.order_item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderItemUseCase {
    public Item getDummy() {
        return new Item("test", new BigDecimal(12));
    }
}
