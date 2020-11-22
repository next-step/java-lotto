package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestStringAdderCalculator {
    private StringAdderCalculator stringAdderCalculator;

    @BeforeEach
    void setUp() {
        stringAdderCalculator = new StringAdderCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사용자 입력 null 또는 빈 문자열에 대한 sum 테스트")
    void checkNullOrEmptyOfUserInput(String userInput) {
        assertThat(stringAdderCalculator.sum(userInput)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("사용자 입력이 , 또는 :로 구분되어서 들어오는 문자열에 대한 sum 테스트")
    @CsvSource(value = {"1$1", "1,2$3", "1,2:3$6"}, delimiter = '$')
    void sumWithUserInput(String userInput, int expected) {
        assertThat(stringAdderCalculator.sum(userInput)).isEqualTo(expected);
    }

    @Disabled("해당 테스트 케이스가 비정상 동작합니다. - 자바지기님 피드백처럼 skip합니다." +
            "현상은 개별로 테스트 하면 정상동작하는데, CsvSource로 묶어서 하면 테스트 실패합니다.")
    @ParameterizedTest
    @DisplayName("사용자 입력이 사용자 정의 구분자와 함께 입력되는 경우에 대한 sum 테스트")
    @CsvSource(value = {"//;\n1;2;3$6", "//#\n1#2#3$6", "//a\n1a2a3$6"}, delimiter = '$')
    void sumWithUserDefineDelimiter(String userInput, int expected) {
        assertThat(stringAdderCalculator.sum(userInput)).isEqualTo(expected);
    }

    @Test
    @DisplayName("사용자 입력이 구분자 ';' 함께 입력되는 경우에 대한 sum 테스트")
    void sumWithPersonalDelimiter() {
        assertThat(stringAdderCalculator.sum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("사용자 입력이 구분자 '#' 함께 입력되는 경우에 대한 sum 테스트")
    void sumWithPersonalDelimiterCrosshatch() {
        assertThat(stringAdderCalculator.sum("//#\n1#2#3")).isEqualTo(6);
    }

    @Test
    @DisplayName("사용자 입력이 구분자 'a' 함께 입력되는 경우에 대한 sum 테스트")
    void sumWithPersonalDelimiterAlphabet() {
        assertThat(stringAdderCalculator.sum("//a\n1a2a3")).isEqualTo(6);
    }

    @Test
    @DisplayName("사용자 입력에 음수가 있는 경우 IllegalArgumentException 발생 테스트")
    void sumWithNegativeOperand() {
        assertThatThrownBy(() -> {
            stringAdderCalculator.sum("-1,2,3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
