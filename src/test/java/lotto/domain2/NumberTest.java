package lotto.domain2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = 1)
    void 생성(final int no) {
        Number number = Number.of(no);
        assertThat(number).isEqualTo(Number.of(no));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 작은숫자_또는_큰숫자_IllegalArgumentsException(final int no) {
        assertThatThrownBy(() -> {
            Number.of(no);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
