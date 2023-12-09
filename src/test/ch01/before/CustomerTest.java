package ch01.before;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    @DisplayName("일반적인 영화의 대여 가격은 2.0$/2일, 포인트는 1.0$")
    void rental_regular_movie_fee(){
        Long expectedTotalAmount = 2L;
        Long expectedFrequentRenterPoints = 1L;
        Customer lim = new Customer("임종완");
        lim.addRental(new Rental(new Movie("아저씨",Movie.REGULAR), 1));

        Map<String, Long> statementReesult = (Map<String, Long>) lim.statement();
        Assertions.assertEquals(expectedTotalAmount,statementReesult.get("totalAmount"));
        Assertions.assertEquals(expectedFrequentRenterPoints,statementReesult.get("frequentRenterPoints"));
    }

    @Test
    @DisplayName("일반영화 대여 가격은 2.0$/2일 이며, 이후에느 1.5$ 씩 부과된다")
    void rental_regular_movie_fee_2days_over(){
        Integer daysOfRented = 4;//기본 2일 + 추가2일
        Long expectedTotalAmount = 5L;
        Long expectedFrequentRenterPoints = 1L;
        Customer lim = new Customer("임종완");
        lim.addRental(new Rental(new Movie("아저씨",Movie.REGULAR), daysOfRented));

        Map<String, Long> statementResult = (Map<String, Long>) lim.statement();
        Assertions.assertEquals(expectedTotalAmount,statementResult.get("totalAmount"));
        Assertions.assertEquals(expectedFrequentRenterPoints,statementResult.get("frequentRenterPoints"));
    }

    @Test
    @DisplayName("새로운 영화는 대여일당 3$ 가 부과된다.")
    void rental_new_movie_fee(){
        //최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        Long expectedTotalAmount = 3L;
        Long expectedFrequentRenterPoints = 1L;
        Integer daysRented = 1;
        Customer lim = new Customer("임종완");
        lim.addRental(new Rental(new Movie("아저씨",Movie.NEW_RELEASE), daysRented));

        Map<String, Long> statementResult = (Map<String, Long>) lim.statement();
        Assertions.assertEquals(expectedTotalAmount,statementResult.get("totalAmount"));
        Assertions.assertEquals(expectedFrequentRenterPoints,statementResult.get("frequentRenterPoints"));
    }

    @Test
    @DisplayName("새로운 영화는 대여일당 3$ 가 부과되며, 2일 이상일경우 추가적인 포인트가 1$ 지급된다")
    void rental_new_movie_fee_promotion(){
        //최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        Long expectedTotalAmount = 6L;
        Long expectedFrequentRenterPoints = 2L;
        Integer daysRented = 2;
        Customer lim = new Customer("임종완");
        lim.addRental(new Rental(new Movie("아저씨",Movie.NEW_RELEASE), daysRented));

        Map<String, Long> statementResult = (Map<String, Long>) lim.statement();
        Assertions.assertEquals(expectedTotalAmount,statementResult.get("totalAmount"));
        Assertions.assertEquals(expectedFrequentRenterPoints,statementResult.get("frequentRenterPoints"));
    }

    @Test
    @DisplayName("애기 영화는 대여일당 1.5$ 가 부과된다.")
    void rental_child_movie_fee(){
        //최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        Long expectedTotalAmount = (long)1.5;
        Long expectedFrequentRenterPoints = 1L;
        Integer daysRented = 1;
        Customer lim = new Customer("임종완");
        lim.addRental(new Rental(new Movie("아저씨",Movie.CHILDRENS), daysRented));

        Map<String, Long> statementResult = (Map<String, Long>) lim.statement();
        Assertions.assertEquals(expectedTotalAmount,statementResult.get("totalAmount"));
        Assertions.assertEquals(expectedFrequentRenterPoints,statementResult.get("frequentRenterPoints"));
    }

    @Test
    @DisplayName("애기 영화는 대여가격은 3일/1.5$ 이며, 기본(3일)이 넘을시 하루당 1.5$ 씩 부과된다")
    void rental_child_movie_fee_3days_over(){
        //최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        Long expectedTotalAmount = 3L;
        Long expectedFrequentRenterPoints = 1L;
        Integer daysRented = 4;
        Customer lim = new Customer("임종완");
        lim.addRental(new Rental(new Movie("아저씨",Movie.CHILDRENS), daysRented));

        Map<String, Long> statementResult = (Map<String, Long>) lim.statement();
        Assertions.assertEquals(expectedTotalAmount,statementResult.get("totalAmount"));
        Assertions.assertEquals(expectedFrequentRenterPoints,statementResult.get("frequentRenterPoints"));
    }
}