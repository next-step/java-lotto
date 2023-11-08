package stringcalculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class SplitterTest {
    
    @Test
    @DisplayName("문자열을 띄어쓰기를 기준으로 입력값을 나누어 문자 배열로 반환한다.")
    void splitString() {
        String inputString = "1 + 2 + 3";

        String[] resultStrings = Splitter.splitString(inputString);

        assertThat(resultStrings).hasSize(5)
                .containsExactly("1", "+", "2", "+", "3");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("비어있는 문자열을 입력하거나 Null을 입력하면 오류가 발생한다.")
    void split_null_공백(String inputString) {
        assertThatIllegalArgumentException().isThrownBy(() -> Splitter.splitString(inputString))
                .withMessageMatching("비어 있는 값은 입력할 수 없습니다.");
    }
}