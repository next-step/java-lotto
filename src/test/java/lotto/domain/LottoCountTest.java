package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1", "a"})
    @DisplayName("로또 개수를 잘못된 값으로 입력받으면 오류난다.")
    void validateTest(String input) {
        assertThatThrownBy(() -> new LottoCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("두개의 로또 개수의 뺄셈을 연산한다.")
    void calculateMinusTest() {
        LottoCount lottoCount = new LottoCount(5);
        LottoCount manualCount = new LottoCount(1);
        assertThat(lottoCount.findAbsoluteValue(manualCount)).isEqualTo(4);
    }
}
