package lotto;

import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("VO객체 선언에 대한 테스트")
    void moneyVoTest() {
        Assertions.assertThat(new Money(10)).isEqualTo(new Money(10));
    }

    @Test
    @DisplayName("곱하기")
    void multiplyTest() {
        Assertions.assertThat(new Money(1).multiply(10)).isEqualTo(new Money(10));
    }

    @Test
    @DisplayName("나누기")
    void divisionTest() {
        Assertions.assertThat(new Money(100).division(new Money(10))).isEqualTo(new Money(10));
    }

    @Test
    @DisplayName("Money Integer로 변환")
    void toIntegerTest() {
        Assertions.assertThat(new Money(100).toInteger()).isEqualTo(100);
    }
}
