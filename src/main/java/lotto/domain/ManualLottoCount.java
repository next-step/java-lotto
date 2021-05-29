package lotto.domain;

import static lotto.util.ValidationUtils.*;

import java.util.Optional;

public class ManualLottoCount {

    private static final String INVALID_LOTTO_COUNT_MESSAGE = "로또 개수는 숫자만 입력할 수 있습니다.";
    private static final String NOT_ENOUGH_MONEY_MESSAGE = "수동 로또를 구매할 금액이 부족합니다.";

    private final int count;

    public ManualLottoCount(String countString, Money money) {
        this.count = validCount(countString, validMoney(money));
    }

    private Money validMoney(Money money) {
        return Optional.ofNullable(money)
            .orElseThrow(() -> new IllegalArgumentException("로또 구입 금액이 유효하지 않습니다."));
    }

    private Integer validCount(String countString, Money validMoney) {
        return Optional.ofNullable(validCountString(countString))
            .map(Integer::parseInt)
            .filter(validMoney::isCapableBuying)
            .orElseThrow(() -> new IllegalArgumentException(NOT_ENOUGH_MONEY_MESSAGE));
    }

    private String validCountString(String countString) {
        return Optional.ofNullable(countString)
            .filter(str -> NUMBER_PATTERN.matcher(str)
                .find())
            .orElseThrow(() -> new IllegalArgumentException(INVALID_LOTTO_COUNT_MESSAGE));
    }

    public int count() {
        return count;
    }
}
