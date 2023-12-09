package ch01.after;

abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int getDaysRented) {
        return 1;
    }
}
