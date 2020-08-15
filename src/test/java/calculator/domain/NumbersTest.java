package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumbersTest {

    @DisplayName("toNumber - 숫자 아닌 문자 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,ㄱ,4", "o-,ds;,"})
    void toNumber_test(String input) {
        Exception exception = assertThrows(RuntimeException.class, () -> Numbers.of(input));

        String expectedMessage = "숫자를 제대로 입력해주세요.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("validateNegativeNumber - 음수값 존재하는 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3,-100,24", "-1"})
    void validateNegativeNumber_test(String input) {
        Exception exception = assertThrows(RuntimeException.class, () -> Numbers.of(input));

        String expectedMessage = "음수는 입력이 불가능합니다.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
