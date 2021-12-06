package lotto.domain.value;

import lotto.service.util.DigitCheckStrategy;

import java.util.Objects;

public class OrderPrice implements DigitCheckStrategy {

    private static final int LOTTO_PRICE = 1000;
    private static final String MIN_MONEY_ERROR_MSG = "원 이상 입력해주세요";

    private final int lottoPrice;

    public OrderPrice(String inputMoney) {

        if((Integer.parseInt(inputMoney)) < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE + MIN_MONEY_ERROR_MSG);
        }

        if(!isDigitCheck(inputMoney)) {
            throw new IllegalArgumentException(NUMBER_CHECK_ERROR_MSG);
        }

        this.lottoPrice = Integer.parseInt(inputMoney);
    }

    @Override
    public boolean isDigitCheck(String inputMoney) {

        for (char c : inputMoney.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderPrice that = (OrderPrice) o;
        return lottoPrice == that.lottoPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrice);
    }

}
