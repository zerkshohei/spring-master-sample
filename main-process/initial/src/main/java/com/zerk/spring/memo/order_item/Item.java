package com.zerk.spring.memo.order_item;


import lombok.Value;

import java.math.BigDecimal;

@Value
public class Item {
    String name;
    BigDecimal price;
}
