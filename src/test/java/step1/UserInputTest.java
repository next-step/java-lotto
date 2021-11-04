package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest {

    @DisplayName("isNullOrEmpty()는 null 값이나 빈 값은 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void addTest(String input) {
        UserInput userInput = new UserInput(input);
        assertThat(userInput.isNullOrEmpty()).isTrue();
    }

}
