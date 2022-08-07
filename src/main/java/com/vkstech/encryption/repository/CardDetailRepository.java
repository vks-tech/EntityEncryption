package com.vkstech.encryption.repository;

import com.vkstech.encryption.entity.CardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDetailRepository extends JpaRepository<CardDetail, Integer> {

    // query using JPA methods
    List<CardDetail> findByCardHolderName(String cardHolderName);

    // query using JPQL
    @Query("select c from CardDetail c where c.cardHolderName = ?1")
    List<CardDetail> findUsingJpql(String name);

    // query using native queries
    @Query(value = "select * from card_detail where card_holder_name = ?1", nativeQuery = true)
    List<CardDetail> findUsingNativeQuery(String name);
}
