package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 돈은 자신을 생성할 수 있다.
 * 돈은 다른 돈에서 자신의 돈을 뺄 수 있다.
 * 돈은 가중치와 다른 돈의 곱의 값에서 자신의 돈을 뺄 수 있다.
 */
public class MoneyTest {
    @Test
    @DisplayName("돈을 생성할 수 있다.")
    void constructorMethod() {
        assertThat(new Money(10000)).isEqualTo(new Money(10000));

        assertThatThrownBy(() -> {
            new Money(-10000);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다른 돈에서 자신의 돈을 뺄 수 있다.")
    void minusMethod() {
        Money money = new Money(10000);

        assertThat(money.minus(new Money(4000))).isEqualTo(new Money(6000));

        assertThatThrownBy(() -> {
            money.minus(new Money(20000));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다른 돈에서 자신의 돈을 뺄 수 있다. (가중치 포함)")
    void minusWithWeightMethod() {
        Money money = new Money(30000);

        assertThat(money.minus(5, new Money(5000))).isEqualTo(new Money(5000));

        assertThatThrownBy(() -> {
            money.minus(10, new Money(10000));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("lessThanMethodSource")
    @DisplayName("다른 돈과 비교하여 자신이 작다면 True, 같거나 큰 경우 False 를 반환한다.")
    void lessThanMethod(Money self, Money other, boolean result) {
        assertThat(self.lessThan(other)).isEqualTo(result);
    }

    static Stream<Arguments> lessThanMethodSource() {
        return Stream.of(
                Arguments.of(new Money(10_000), new Money(20_000), true),
                Arguments.of(new Money(20_000), new Money(10_000), false),
                Arguments.of(new Money(20_000), new Money(20_000), false)
        );
    }

    @Test
    @DisplayName("다른 돈으로 나눈 몫을 반환할 수 있다.")
    void quotientMethod() {
        Money self = new Money(10_000);
        Money other = new Money(1_000);
        assertThat(self.quotient(other)).isEqualTo(10);

        assertThatThrownBy(() -> {
            self.quotient(new Money(0));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
