package ch01.after;

public class RegularPrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int getDaysRented) {
        double result = 2;
        if (getDaysRented > 2) {
            result += (getDaysRented - 2) * 1.5;
        }

        return result;
    }
}
