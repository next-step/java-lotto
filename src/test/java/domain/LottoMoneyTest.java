package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 997, 998, 999})
    @DisplayName("로또 구입 금액이 1000원 미만이면 예외를 발생시킨다")
    void newMoneyTest(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMoney(input));
    }

}
