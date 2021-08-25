package lotto.domain;

import lotto.exception.InputError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("Money 객체 생성, 음수면 에러")
    @Test
    void create_error() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(InputError.class);
    }

    @DisplayName("Money 객체 생성 equals 테스트")
    @Test
    void create() {
        assertThat(new Money(100)).isEqualTo(new Money(100));
    }

    @DisplayName("구매할 수 있는 갯수")
    @Test
    void divide() {
        assertThat(new Money(1000).divideBy(new Money(1000))).isEqualTo(1);
        assertThat(new Money(10000).divideBy(new Money(1000))).isEqualTo(10);
    }
}