package ch01.after;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public Price getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case REGULAR:
                this.priceCode = new RegularPrice();
                break;
            case CHILDRENS:
                this.priceCode = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                this.priceCode = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("가격 코드가 잘못됐습니다.");
        }
    }

    public int getFrequentRenterPoints(int daysRented) {
        return priceCode.getFrequentRenterPoints(daysRented);
    }
}
