package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {
    @Test
    void create() {
        assertThat(new Number(3)).isEqualTo(new Number(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위_벗어난_경우(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(number))
                .withMessageMatching("로또 숫자는 1 이상 45 이하여야 합니다.");
    }

    @Test
    void getNumber() {
        Number number = new Number(3);
        assertThat(number.getNumber()).isEqualTo(3);
    }
}
