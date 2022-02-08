package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"10000", "1000"})
    void 입력한_숫자에_해당한_객체를_만든다(String money) {
        Money createMoney = new Money(money);
        assertThat(Integer.parseInt(money)).isEqualTo(createMoney.value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"jason", "1000원", " ", ""})
    void 문자를_입력한_경우_예외를_발생시킨다(String money) {
        assertThatThrownBy(() -> new Money(money))
            .hasMessageContaining("[ERROR]")
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "900"})
    void 구매할_수_없는_금액을_입력한_경우_예외를_발생시킨다(String money) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Money(money));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000", "1000"})
    void 금액에_따른_구매_매수를_반환할_수_있다(String money) {
        Money createMoney = new Money(money);
        int expectCount = Integer.parseInt(money) / 1_000;
        assertThat(createMoney.getCount()).isEqualTo(expectCount);
    }
}
