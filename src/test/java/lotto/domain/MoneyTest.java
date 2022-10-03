package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @Test
    @DisplayName("같은 액수를 지니고 있는 돈은 같은 객체이다.")
    void create() {
        assertThat(new Money(10_000)).isEqualTo(new Money(10_000));
    }

    @Test
    @DisplayName("음수 액수를 지닌 객체를 생성할 수 없다.")
    void createWithNegativeInteger() {
        assertThatThrownBy(() -> new Money(-1_000))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("음수가 될 수 없습니다");
    }

    @Test
    @DisplayName("돈 객체 끼리의 뺄셈 연산")
    void minus() {
        assertThat(new Money(10_000).minus(new Money(4_000))).isEqualTo(new Money(6_000));
    }

    @Test
    @DisplayName("뺄셈 연산이 음수가 되면 예외")
    void minusException() {
        assertThatThrownBy(() -> new Money(100).minus(new Money(1_000)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "두 수 간의 대소 비교: {0} {1}")
    @CsvSource(value = {
        "1000,2000,false",
        "2000,1000,true",
        "2000,2000,true"
    })
    void isGreaterThanOrEqual(int money1, int money2, boolean expected) {
        assertThat(new Money(money1).isGreaterThanOrEqual(new Money(money2))).isEqualTo(expected);
    }
}
