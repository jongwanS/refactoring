package ch01.after;

public class ChildrensPrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double getCharge(int getDaysRented) {
        double result = 1.5;
        if (getDaysRented > 3) {
            result += (getDaysRented - 3) * 1.5;
        }
        return result;
    }
}
