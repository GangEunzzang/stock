package com.example.stock.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private Long quantity;

    @Version
    private Long version;

    public Stock (long productId, long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void decrease(Long quantity) {
        if (this.quantity - quantity < 0) {
            throw new RuntimeException("재고는 0개미만이 될 수 없습니다.");
        }

        this.quantity -= quantity;
    }

}
