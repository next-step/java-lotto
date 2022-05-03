package lotto.domain;

public class LottoTotalPrice {
    private static final int UNIT_LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private final int totalPrice;

    LottoTotalPrice(int totalPrice) {
        this.totalPrice = validateTotalPriceRange(totalPrice);
    }

    public LottoTotalPrice(String totalPrice) {
        if (!isDigit(totalPrice)) {
            throw new IllegalArgumentException(String.format("%s는 숫자가 아닙니다.", totalPrice));
        }
        this.totalPrice = validateTotalPriceRange(Integer.parseInt(totalPrice));
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public int getPurchaseLottoCount() {
        return this.totalPrice / UNIT_LOTTO_PRICE;
    }

    private boolean isDigit(String number) {
        return number.chars().filter(c -> c != '-').allMatch(Character::isDigit);
    }

    private int validateTotalPriceRange(int totalPrice) {
        if (totalPrice < ZERO) {
            throw new IllegalArgumentException(String.format("구매금액(입력 받은 구매 금액 : %d)은 음수일 수 없습니다.", totalPrice));
        }
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoTotalPrice that = (LottoTotalPrice) o;

        return totalPrice == that.totalPrice;
    }

    @Override
    public int hashCode() {
        return totalPrice;
    }
}
