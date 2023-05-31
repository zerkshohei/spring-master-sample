package com.zerk.spring.memo.order_item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderItemApi {

    private final OrderItemUseCase orderItemUseCase;

    @GetMapping("/item")
    public Item getItem() {
        return orderItemUseCase.getDummy();
    }
}
