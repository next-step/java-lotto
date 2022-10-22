package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @DisplayName("value 가 0보다 작으면 IllegalArgumentException 예외를 발생시킨다.")
    @Test
    void constructor() {
        assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class).hasMessage("Value cannot be less than 0.");
    }

    @DisplayName("로또 가격이 1000 원이라면 구매갯수는 지불금액을 로또가격으로 나누고 소수점 이하는 버린 갯수이다.")
    @ParameterizedTest
    @CsvSource(value = { "10000=10", "10900=10", "2000=2" }, delimiter = '=')
    void lottoCount(long paidMoney, int expectedCount) {
        assertThat(new Money(paidMoney).lottoCount(new Money(1000))).isEqualTo(expectedCount);
    }

    @DisplayName("value 가 0보다 작다면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = { -1, -10, -5 })
    void money(long value) {
        assertThatThrownBy(() -> {
            new Money(value);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessage("Value cannot be less than 0.");
    }

    @DisplayName("가격의 금액을 리턴한다.")
    @ParameterizedTest
    @ValueSource(longs = { 1_000L, 10_000L, 1_500L, 0L })
    void value(long value) {
        assertThat(new Money(value).value()).isEqualTo(value);
    }
}
