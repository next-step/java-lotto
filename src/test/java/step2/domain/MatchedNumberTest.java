package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchedNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 1", "15, 14, 2, 1", "11, 12, 14, 15, 16", "40, 31, 31, 24, 1, 4"})
    @DisplayName("중복되지 않은 6개의 숫자가 아니면 예외를 던진다")
    public void notMatchedNumberCount(String inputText) {
        assertThatThrownBy(() -> {
            new MatchedNumber(inputText);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 13", "15, 14, 2, 12, 10, 33", "11, 12, 14, 15, 16, 40"})
    @DisplayName("유효한 당첨 번호를 받으면 객체는 정상적으로 생성된다")
    public void validMatchedNumber(String inputText) {
        assertThat(new MatchedNumber(inputText)).isNotNull();
    }
}
