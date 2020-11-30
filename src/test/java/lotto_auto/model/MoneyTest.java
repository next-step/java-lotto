package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("돈 유효성 검증 테스트")
    @Test
    public void negativeMoneyExceptionTest() {
        assertThatThrownBy(
                () -> {
                    Money money = new Money(-1);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Money 객체 getMoney 생성한 돈을 잘 가져오는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            10,
            30,
            40,
            100
    })
    public void getMoneyTest(int value) {
        Money money = new Money(value);
        assertThat(money.getMoney()).isEqualTo(value);
    }


}
