package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {
    @Test
    void test_숫자비교() {
        Number x = new Number(1);
        Number y = new Number(2);
        assertThat(x.compareTo(y) < 0).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 80})
    void exceptionTest_범위를_넘는_값(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }
}