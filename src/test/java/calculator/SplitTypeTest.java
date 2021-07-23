package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SplitTypeTest {

    @DisplayName("구분자가 일치하는 타입을 리턴 받는다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3-DEFAULT", "10-SINGLE"}, delimiter = '-')
    void get_split_type(String str, SplitType type) {
        System.out.println("str = " + str);
        assertThat(SplitType.getSplitType(str)).isEqualTo(type);
    }

    @DisplayName("커스텀 구분자와 일치하는 타입을 리턴 받는다")
    @Test
    void get_custom_pattern() {
        // 개행 문자가 CsvSource 에서 정상적으로 인식이 안되서 별도의 테스트로 분리
        assertThat(SplitType.getSplitType("//;\n1;2;3-CUSTOM")).isEqualTo(SplitType.CUSTOM);
    }
}