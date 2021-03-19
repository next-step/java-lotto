package study.lotto.view.dto;

import study.lotto.exception.LottoException;

import java.math.BigDecimal;
import java.util.Objects;

import static study.lotto.view.InputView.LOTTO_PRICE;

public class RequestMoney {

    public static final String CANNOT_BUY_LOTTO = "구매가 불가능합니다.";
    private final int autoLottoCount;
    private final int money;

    public RequestMoney(final int money) {
        this(money, 0);
    }

    public RequestMoney(int money, int manualCount) {
        if(money < LOTTO_PRICE) {
            throw new LottoException(CANNOT_BUY_LOTTO);
        }
        this.money = money;
        this.autoLottoCount = divideMoneyByPrice() - manualCount;
    }

    public int divideMoneyByPrice() {
        return BigDecimal.valueOf(money)
                .divide(BigDecimal.valueOf(LOTTO_PRICE))
                .intValue();
    }

    public int autoCount() {
        return autoLottoCount;
    }

    public double winningRate(long sum) {
        return (double) sum / money;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestMoney)) return false;
        final RequestMoney money1 = (RequestMoney) o;
        return autoLottoCount == money1.autoLottoCount
                && money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, autoLottoCount);
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
