package com.vkstech.encryption;

import com.vkstech.encryption.config.AesEncryptor;
import com.vkstech.encryption.entity.CardDetail;
import com.vkstech.encryption.repository.CardDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EncryptionDemoApplicationTests {

    @Autowired
    private CardDetailRepository cardDetailRepository;

    @Autowired
    private AesEncryptor aesEncryptor;

    @Test
    void contextLoads() {
    }


    @Test
    void insertData() {
        CardDetail cardDetail = new CardDetail();
        cardDetail.setCardHolderName("VKSTECH");
        cardDetail.setCvv(123);
        cardDetail.setAmount(100.0);
        cardDetail.setIsActive(false);

        cardDetailRepository.save(cardDetail);
    }

    @Test
    void retrieveData() {
        CardDetail cardDetail = cardDetailRepository.findById(1).get();
        System.out.println(cardDetail);
    }

    @Test
    void insertBatchData() {
        CardDetail cardDetail1 = new CardDetail();
        cardDetail1.setCardHolderName("Tom");
        cardDetail1.setCvv(456);
        cardDetail1.setAmount(200.0);
        cardDetail1.setIsActive(true);

        CardDetail cardDetail2 = new CardDetail();
        cardDetail2.setCardHolderName("Nick");
        cardDetail2.setCvv(789);
        cardDetail2.setAmount(300.0);
        cardDetail2.setIsActive(true);

        CardDetail cardDetail3 = new CardDetail();
        cardDetail3.setCardHolderName("Harry");
        cardDetail3.setCvv(901);
        cardDetail3.setAmount(400.0);
        cardDetail3.setIsActive(false);

        List<CardDetail> cardDetails = new ArrayList<>();
        cardDetails.add(cardDetail1);
        cardDetails.add(cardDetail2);
        cardDetails.add(cardDetail3);

        cardDetailRepository.saveAll(cardDetails);
    }

    @Test
    void retrieveDataJpql() {
        CardDetail cardDetail = cardDetailRepository.runQuery(aesEncryptor.convertToDatabaseColumn("Tom")).get(0);
        System.out.println(cardDetail);
    }

}
