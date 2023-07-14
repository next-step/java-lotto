package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"99999", "1000", "1001", "100000"})
    @DisplayName("구입 금액 정상 생성 입력 테스트")
    void money_inputValidMoney(final String value) {
        /* given & when & then */
        assertDoesNotThrow(() -> new Money(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"999", "100001"})
    @DisplayName("범위 초과 구입 금액 생성 테스트")
    void money_inputOutOfRangeMoney(final String value) {
        /* given & when & then */
        assertThatThrownBy(() -> new Money(value)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "100,000"})
    @DisplayName("숫자가 아닌 문자열 입력 테스트")
    void money_notNumericInput(final String value) {
        /* given & when & then */
        assertThatThrownBy(() -> new Money(value)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("원하는 로또 개수만큼 구매한 후 받은 금액 테스트")
    void money_receiveAfterPurchaseLotto() {
        Money money = new Money("10000");
        final Money receiveMoney = money.receiveAfterPurchaseLotto(new LottoBuyCount("10"));

        assertThat(receiveMoney.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("원하는 로또 개수만큼 구매할 수 있는지 검증하는 테스트")
    void money_validateCanPurchaseLottoWantedCount() {
        Money money = new Money("9999");
        assertThatThrownBy(() -> money.validateCanPurchaseLottoWantedCount(new LottoBuyCount("10")))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
