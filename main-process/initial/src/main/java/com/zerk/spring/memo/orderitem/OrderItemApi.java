package com.zerk.spring.memo.orderitem;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderItemApi {

    private final OrderItemUseCase orderItemUseCase;

    @GetMapping("/item/{id}")
    public Item getItem() {
        return orderItemUseCase.getDummy();
    }

    @GetMapping("/item")
    public Item getItemList() {
        return orderItemUseCase.getDummy();
    }
}
