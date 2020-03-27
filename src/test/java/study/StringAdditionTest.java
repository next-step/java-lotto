package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.domain.StringAddition;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAdditionTest {
    @DisplayName("기본 구분자를 이용한 덧셈")
    @ParameterizedTest
    @CsvSource(value = {"0,1=1", "1:1=2", "1,2:3=6"}, delimiter = '=')
    void defaultSeparator(String operands, int result) {
        assertThat(StringAddition.splitAndSum(operands)).isEqualTo(result);
    }

}
