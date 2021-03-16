package study.lotto.view.dto;

import study.lotto.exception.LottoException;

import java.util.Objects;

import static study.lotto.view.InputView.LOTTO_PRICE;

public class RequestMoney {

    public static final String CANNOT_BUY_LOTTO = "구매가 불가능합니다.";
    private final int totalLottoCount;

    public RequestMoney(int money) {
        if(money < LOTTO_PRICE) {
            throw new LottoException(CANNOT_BUY_LOTTO);
        }
        totalLottoCount = money / LOTTO_PRICE;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestMoney)) return false;
        final RequestMoney money = (RequestMoney) o;
        return totalLottoCount == money.totalLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalLottoCount);
    }
}
