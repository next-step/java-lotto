package domain;

import static domain.UserInput.EMPTY_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputTest {

    @ParameterizedTest(name = "비어있는 값을 입력하는 경우 오류를 발생시킨다.")
    @ValueSource(strings = {"", "\t", "\n"})
    void emptyNameSettingFail(String userInput) {
        assertThatThrownBy(() -> new UserInput(userInput))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_ERROR_MESSAGE);
    }


    @ParameterizedTest(name = "공백에 맞춰 문자열을 분리한다.")
    @CsvSource(value = "안 녕 하 세 요:5", delimiter = ':')
    void separateTest(String userInput, int expected) {
        assertThat(new UserInput(userInput)
                .separateInputWithBlank()
                .size())
                .isEqualTo(expected);
    }
}
