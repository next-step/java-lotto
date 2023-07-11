package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"99999", "1000", "1001", "100000"})
    @DisplayName("구입 금액 정상 생성 입력 테스트")
    void money_inputValidMoney(final String value) {
        /* given & when & then */
        Assertions.assertDoesNotThrow(() -> new Money(value));
    }

}
