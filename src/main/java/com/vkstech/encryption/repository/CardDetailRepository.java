package com.vkstech.encryption.repository;

import com.vkstech.encryption.entity.CardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDetailRepository extends JpaRepository<CardDetail, Integer> {

    @Query(value = "select * from card_detail c where c.card_holder_name = ?1", nativeQuery = true)
    List<CardDetail> runQuery(String name);
}
