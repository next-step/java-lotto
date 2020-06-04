package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("문자열을 컴마형태로 분리")
    public void ofComma() {
        Lotto lotto = Lotto.ofComma("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열 null시 예외처리")
    public void ofComma_문자열_isNull(String input) {
        assertThatThrownBy(() -> Lotto.ofComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}