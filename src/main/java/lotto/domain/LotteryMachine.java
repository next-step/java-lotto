package lotto.domain;

public class LotteryMachine {

    private static final int LOTTO_PRICE = 1_000;

    private final int purchasePrice;

    private final int issuedLottoNumber;

    public int getIssuedLottoNumber() {
        return issuedLottoNumber;
    }

    public LotteryMachine(final String purchasePrice) {
        this(Integer.parseInt(purchasePrice));
    }

    public LotteryMachine(final int purchasePrice) {
        valid(purchasePrice);
        this.purchasePrice = purchasePrice;
        issuedLottoNumber = purchasePrice / LOTTO_PRICE;
    }

    private void valid(final int price) {
        if (price < 0) {
            throw new IllegalArgumentException("가격은 0보다 작은 값일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LotteryMachine that = (LotteryMachine) o;

        return purchasePrice == that.purchasePrice;
    }

    @Override
    public int hashCode() {
        return purchasePrice;
    }
}
