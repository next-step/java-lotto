package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AmountTest {
    @DisplayName("두 Amount를 나눈 값을 소수점 2자리까지 표현한다.")
    @Test
    void 나눗셈() {
        Amount numerator = Amount.of(243000);
        Amount denominator = Amount.of(7000);
        Assertions.assertThat(numerator.divideToBigDecimal(denominator.amount(), 2)).isEqualTo(new BigDecimal("34.71"));
    }

    @DisplayName("값 비교")
    @Test
    void 비교() {
        Amount biggestAmount = Amount.of(243000);
        Amount amount = Amount.of(7000);
        Amount otherAmount = Amount.of(7000);
        Assertions.assertThat(biggestAmount.compareTo(amount)).isEqualTo(1);
        Assertions.assertThat(amount.compareTo(biggestAmount)).isEqualTo(-1);
        Assertions.assertThat(amount.compareTo(otherAmount)).isEqualTo(0);
    }
    @DisplayName("두 값을 뺀 Amount를 리턴한다.")
    @Test
    void 빼기() {
        Amount biggestAmount = Amount.of(243000);
        Amount amount = Amount.of(7000);
        Assertions.assertThat(biggestAmount.minus(amount)).isEqualTo(Amount.of(236000));
    }
    
}