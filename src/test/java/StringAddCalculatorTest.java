import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    //1. 쉼표 또는 콜론을 구분자로 문자열을 분리한다.
    //1. 숫자들의 합을 반환한다 (기본 값은 0이다.)
    //1. 커스텀 구분자를 지정 할 수 있다. ("//" 와 "\n 사이" 문자)
    //1. 숫자 외에, 음수를 전달하면 에러가 발생한다.

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"})
    @DisplayName("문자열을 쉼표, 혹은 콜론으로 구분하여 숫자를 리스트로 반환한다.")
    void splitStringAndReturnNumberList(String input) {
        List<Integer> result = stringAddCalculator.splitAndReturnNumberList(input);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 입력시 0 하나를 원소로 가지는 리스트를 반환한다.")
    void splitEmptyStringAndReturnNumberList(String input) {
        List<Integer> result = stringAddCalculator.splitAndReturnNumberList(input);
        assertThat(result).containsExactly(0);
    }
}
