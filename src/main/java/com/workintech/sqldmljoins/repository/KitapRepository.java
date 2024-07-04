package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KitapRepository extends JpaRepository<Kitap, Long> {

    //Dram ve Hikaye türündeki kitapları listeleyin. JOIN kullanmadan yapın.
    String QUESTION_1 = "select k.* from kitap as k, tur as t\n" +
            "where k.turno = t.turno and t.ad in('Hikaye','Dram');";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Kitap> findBooks();


    //Tüm kitapların ortalama puanını bulunuz.
    String QUESTION_10 = "select round(avg(k.puan),2) from kitap k";
    @Query(value = QUESTION_10, nativeQuery = true)
    Double findAvgPointOfBooks();


}
