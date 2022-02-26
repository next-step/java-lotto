package lotto.domain.lotto.count;

import lotto.domain.money.Money;

public class Count {

    private static final int LOTTO_MONEY = 1000;

    private final int value;

    public Count(String value) {
        this(parseToInteger(value));
    }

    private static Integer parseToInteger(String value) {
        if (!value.matches("[-]?[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 들어올 수 있습니다.");
        }
        return Integer.parseInt(value);
    }

    public Count(Integer value) {
        validCount(value);
        this.value = value;
    }

    private void validCount(Integer value) {
        validRange(value);
    }

    private void validRange(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException("[ERROR] 구매 개수가 0보다 작을 수는 없습니다.");
        }
    }

    public static Count calculateLottoCount(Money money) {
        return new Count(money.getValue() / LOTTO_MONEY);
    }

    public static Count calculateAutoCount(Count totalCount, ManualCount manualCount) {
        return new Count(totalCount.getValue() - manualCount.getCountValue());
    }

    public Integer getValue() {
        return value;
    }

    public boolean overCount(int count) {
        return value < count;
    }
}
