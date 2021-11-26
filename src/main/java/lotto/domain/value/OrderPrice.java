package lotto.domain.value;

import java.util.Objects;

public class OrderPrice {

    private static final int LOTTO_PRICE = 1000;
    private static final String MIN_MONEY_ERROR_MSG = "1000원 이상 입력해주세요";
    private static final String NUMBER_CHECK_ERROR_MSG = "숫자만 입력 가능합니다!!!!";

    private final int lottoPrice;

    public OrderPrice(String inputMoney) {

        constantCheck(inputMoney);
        moneySizeCheck(inputMoney);

        this.lottoPrice = Integer.parseInt(inputMoney);
    }

    private void constantCheck(String orderPrice) {

        for (char c : orderPrice.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(NUMBER_CHECK_ERROR_MSG);
            }
        }
    }

    private void moneySizeCheck(String inputMoney) {
        if (Integer.parseInt(inputMoney) < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_ERROR_MSG);
        }
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
