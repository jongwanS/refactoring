package ch01.after;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    @DisplayName("일반적인 영화의 대여 가격은 2.0$/2일, 포인트 적립은 1.0$ 이다")
    void rental_regular_movie_fee(){
        double expectedTotalAmount = 2L;
        double expectedFrequentRenterPoints = 1L;
        Customer lim = new Customer("임종완");
        Rental rental = new Rental(new Movie("아저씨", Movie.REGULAR), 1);
        lim.addRental(rental);

        Assertions.assertEquals(expectedTotalAmount,rental.getCharge());
        Assertions.assertEquals(expectedFrequentRenterPoints,rental.getFrequentRenterPoints());
    }

    @Test
    @DisplayName("일반영화 대여 가격은 2.0$/2일 이며, 이후에느 1.5$ 씩 부과된다")
    void rental_regular_movie_fee_2days_over(){
        Integer daysOfRented = 4;//기본 2일 + 추가2일
        double expectedTotalAmount = 5L;
        double expectedFrequentRenterPoints = 1L;
        Customer lim = new Customer("임종완");
        Rental rental = new Rental(new Movie("아저씨", Movie.REGULAR), daysOfRented);
        lim.addRental(rental);

        Assertions.assertEquals(expectedTotalAmount,rental.getCharge());
        Assertions.assertEquals(expectedFrequentRenterPoints,rental.getFrequentRenterPoints());
    }

    @Test
    @DisplayName("새로운 영화는 대여일당 3$ 가 부과된다.")
    void rental_new_movie_fee(){
        //최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        double expectedTotalAmount = 3L;
        double expectedFrequentRenterPoints = 1L;
        Integer daysRented = 1;
        Customer lim = new Customer("임종완");
        Rental rental = new Rental(new Movie("아저씨", Movie.NEW_RELEASE), daysRented);
        lim.addRental(rental);

        Assertions.assertEquals(expectedTotalAmount,rental.getCharge());
        Assertions.assertEquals(expectedFrequentRenterPoints,rental.getFrequentRenterPoints());
    }

    @Test
    @DisplayName("새로운 영화는 대여일당 3$ 가 부과되며, 2일 이상일경우 추가적인 포인트가 1$ 지급된다")
    void rental_new_movie_fee_promotion(){
        //최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        long expectedTotalAmount = 6L;
        long expectedFrequentRenterPoints = 2L;
        Integer daysRented = 2;
        Customer lim = new Customer("임종완");
        Rental rental = new Rental(new Movie("아저씨", Movie.NEW_RELEASE), daysRented);
        lim.addRental(rental);

        Assertions.assertEquals(expectedTotalAmount,rental.getCharge());
        Assertions.assertEquals(expectedFrequentRenterPoints,rental.getFrequentRenterPoints());
    }

    @Test
    @DisplayName("애기 영화는 대여일당 1.5$ 가 부과된다.")
    void rental_child_movie_fee(){
        //최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        double expectedTotalAmount = 1.5;
        double expectedFrequentRenterPoints = 1L;
        Integer daysRented = 1;
        Customer lim = new Customer("임종완");
        Rental rental = new Rental(new Movie("아저씨", Movie.CHILDRENS), daysRented);
        lim.addRental(rental);

        Assertions.assertEquals(expectedTotalAmount,rental.getCharge());
        Assertions.assertEquals(expectedFrequentRenterPoints,rental.getFrequentRenterPoints());
    }

    @Test
    @DisplayName("애기 영화는 대여가격은 3일/1.5$ 이며, 기본(3일)이 넘을시 하루당 1.5$ 씩 부과된다")
    void rental_child_movie_fee_3days_over(){
        //최신을 이틀 이상 대여하는 경우 추가 포인트 제공
        double expectedTotalAmount = 3L;
        double expectedFrequentRenterPoints = 1L;
        Integer daysRented = 4;
        Customer lim = new Customer("임종완");
        Rental rental = new Rental(new Movie("아저씨", Movie.CHILDRENS), daysRented);
        lim.addRental(rental);

        Assertions.assertEquals(expectedTotalAmount,rental.getCharge());
        Assertions.assertEquals(expectedFrequentRenterPoints,rental.getFrequentRenterPoints());
    }
}