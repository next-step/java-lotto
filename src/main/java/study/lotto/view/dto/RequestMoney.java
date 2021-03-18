package study.lotto.view.dto;

import study.lotto.exception.LottoException;

import java.util.Objects;

import static study.lotto.view.InputView.LOTTO_PRICE;

public class RequestMoney {

    public static final String CANNOT_BUY_LOTTO = "구매가 불가능합니다.";
    private final int totalLottoCount;
    private final int money;

    public RequestMoney(final int money) {
        if(money < LOTTO_PRICE) {
            throw new LottoException(CANNOT_BUY_LOTTO);
        }
        this.money = money;
        totalLottoCount = money / LOTTO_PRICE;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestMoney)) return false;
        final RequestMoney money1 = (RequestMoney) o;
        return totalLottoCount == money1.totalLottoCount
                && money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, totalLottoCount);
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }

    public double winningRate(long sum) {
        return (1.0 * sum) / money;
    }
}
