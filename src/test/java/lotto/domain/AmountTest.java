package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
    @DisplayName("두 Amount를 나눈 값을 소수점 2자리까지 표현한다.")
    @Test
    void 나눗셈() {
        Amount numerator = new Amount(243000);
        Amount denominator = new Amount(7000);
        Assertions.assertThat(numerator.divide(denominator.amount(), 2)).isEqualTo(new BigDecimal("34.71"));
    }

    @DisplayName("값 비교")
    @Test
    void 비교() {
        Amount biggestAmount = new Amount(243000);
        Amount amount = new Amount(7000);
        Amount otherAmount = new Amount(7000);
        Assertions.assertThat(biggestAmount.compareTo(amount)).isEqualTo(1);
        Assertions.assertThat(amount.compareTo(biggestAmount)).isEqualTo(-1);
        Assertions.assertThat(amount.compareTo(otherAmount)).isEqualTo(0);
    }
    @DisplayName("두 값을 뺀 Amount를 리턴한다.")
    @Test
    void 빼기() {
        Amount biggestAmount = new Amount(243000);
        Amount amount = new Amount(7000);
        Assertions.assertThat(biggestAmount.minus(amount)).isEqualTo(new Amount(236000));
    }
    
}