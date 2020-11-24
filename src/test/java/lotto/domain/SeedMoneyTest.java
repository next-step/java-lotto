package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-11-19.
 */
class SeedMoneyTest {

    @ParameterizedTest
    @DisplayName("구입금액이 null 이거나 빈문자열일 때 예외를 던진다")
    @NullAndEmptySource
    void lotto_money_is_null_or_empty(String inputMoney) {
        assertThatThrownBy(() -> SeedMoney.from(inputMoney))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(SeedMoney.MESSAGE_NON_NULL);
    }

    @ParameterizedTest
    @DisplayName("입력한 구입금액이 숫자형이 아닌 경우 예외를 던진다")
    @ValueSource(strings = {"0, -24, ", "가", "1가"})
    void is_lotto_money_number(String inputMoney) {
        assertThatThrownBy(() -> SeedMoney.from(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SeedMoney.MESSAGE_NUMBER);
    }

    @ParameterizedTest
    @DisplayName("입력한 구입금액이 양수지만 1000원으로 나눠지지 않는 경우 예외를 던진다")
    @ValueSource(strings = {"1020","2730","2002","2200"})
    void is_lotto_money_divided(String inputMoney) {
        assertThatThrownBy(() -> SeedMoney.from(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SeedMoney.MESSAGE_MONEY_TIMES);
    }

    @ParameterizedTest
    @DisplayName("입력한 구입금액이 양수가 아닌 경우 예외를 던진다")
    @ValueSource(strings = {"0", "-24", "-1", "-2"})
    void is_lotto_money_round(String inputMoney) {
        assertThatThrownBy(() -> SeedMoney.from(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SeedMoney.MESSAGE_ROUND_TIMES);

    }

}
