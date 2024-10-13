package lotto.domain;

public class LotteryMachine {

    private static final int LOTTO_PRICE = 1_000;

    public int getIssuedLottoNumber() {
        return issuedLottoNumber;
    }

    private final int purchasePrice;

    private final int issuedLottoNumber;

    public LotteryMachine(final String purchasePrice) {
        this(Integer.parseInt(purchasePrice));
    }

    public LotteryMachine(final int purchasePrice) {
        this.purchasePrice = purchasePrice;
        issuedLottoNumber = purchasePrice / LOTTO_PRICE;
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
