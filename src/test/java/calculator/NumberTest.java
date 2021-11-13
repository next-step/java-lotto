package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("문자열로 생성")
    @ParameterizedTest(name = "[{index}] number: {0}")
    @ValueSource(ints = {0, 1, 100})
    void create(int number) {
        Number positive = Number.from(String.valueOf(number));
        assertThat(positive).isEqualTo(new Number(number));
    }

    @DisplayName("입력이 양수가 아니라면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "-1", "!", "12ad", "!a"})
    void create_illegalFormat(String illegalFormatNumber) {
        assertThatThrownBy(() -> Number.from(illegalFormatNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Number.NOT_NUMBER_ERROR_MESSAGE);
    }

    @DisplayName("덧셈")
    @ParameterizedTest(name = "[{index}] {0} + {1}")
    @CsvSource("100, 3")
    public void plus(int left, int right) {
        //given
        Number number = new Number(left);

        //when
        Number sum = number.plus(new Number(right));

        //then
        assertThat(sum).isEqualTo(new Number(left + right));
    }

}
