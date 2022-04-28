package com.vkstech.encryption.entity;

import com.vkstech.encryption.config.AesEncryptor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CardDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Convert(converter = AesEncryptor.class)
    private String cardHolderName;

    @Convert(converter = AesEncryptor.class)
    private Integer cvv;

    @Convert(converter = AesEncryptor.class)
    private Double amount;

    @Convert(converter = AesEncryptor.class)
    private Boolean isActive;
}
