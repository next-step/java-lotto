package lotto.domain;

public class Amount {
    private Amount() {
    }

    public static Integer getAmount(Integer matchedCount) {
        return AmountEnum.from(matchedCount).getAmount();
    }

    public static Integer getBuyLottoNumber(final int amount) {
        return amount / 1000;
    }
}
