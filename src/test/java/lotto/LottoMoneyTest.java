package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoMoneyTest {

    @DisplayName("로또 금액이 음수 일때 Exception 이 발생합니다.")
    @ParameterizedTest
    @ValueSource(ints={-50, -100, -500, -1000})
    public void testIfNegativeValueThenInvokedException(int money) {
        assertThatIllegalStateException(() -> LottoMoney.of(money));
    }

    @DisplayName("로또 금액이 1000원 미만이라면 Exception 이 발생합니다.")
    @ParameterizedTest
    @ValueSource(ints={500, 600, 700, 800, 900})
    public void testIfMoneySmallerThan1000ThenInvokedException(int money) {
        assertThatIllegalStateException(() -> LottoMoney.of(money));
    }
}
