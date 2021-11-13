package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveTest {

    @DisplayName("문자열로 생성 잘 되는지")
    @ParameterizedTest(name = "[{index}] number: {0}")
    @ValueSource(ints = {1, 100, 1000})
    void create(int number) {
        Positive positive = Positive.from(String.valueOf(number));
        assertThat(positive).isEqualTo(new Positive(number));
    }

    @DisplayName("입력이 양수가 아니라면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "0", "-1", "!", "12ad", "!a"})
    void create_illegalFormat(String illegalFormatNumber) {
        assertThatThrownBy(() -> Positive.from(illegalFormatNumber))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Positive.NON_POSITIVE_ERROR_MESSAGE);
    }

}
