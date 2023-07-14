package lotto;

import lotto.domain.Count;
import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

    @Test
    @DisplayName("개수를 생성한다.")
    void create() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Count(0));
    }

    @Test
    @DisplayName("음수 입력시 생성자가 예외를 던진다.")
    void validatePositive() {
        Assertions.assertThatThrownBy(() -> new Count(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("count번 반복할 수 있는 스트림을 반환한다.")
    void stream() {
        int value = 5;
        Count count = new Count(5);

        Assertions.assertThat(count.stream().count()).isEqualTo(value);
    }

    @Test
    @DisplayName("물건 값(Money)을 곱하면 총 얼마인지 Money를 반환한다.")
    void multiply() {
        Count count = new Count(5);
        Money price = new Money(1000);

        Assertions.assertThat(count.multiply(price)).isEqualTo(new Money(5000));
    }
}
