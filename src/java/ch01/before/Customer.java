package ch01.before;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }
    public void addRental(Rental rental){
        rentals.add(rental);
    }
    public String getName() {
        return name;
    }

    public Map<?,?> statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental)rentals.nextElement();

            // 각 영화에 대한 요금 결정
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            // 포인트 추가
            frequentRenterPoints++;
            // 최신을 이틀 이상 대여하는 경우 추가 포인트 제공
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    (each.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            // 이 대여에 대한 요금 계산 결과 표시
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // 풋터(footer) 추가
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                "frequent renter points";

        System.out.println(result);

        Map<String, Long> map = new HashMap<>();
        map.put("totalAmount", (long) totalAmount);
        map.put("frequentRenterPoints", (long) frequentRenterPoints);
        return map;
    }
}
