package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ExtractorTest {

    @ParameterizedTest
    @CsvSource(
            value = {
            "5,10,3|5|10|3",
            "3:5:10|3|5|10",
            "3,20:5|3|20|5"
            },
            delimiter = '|')
    @DisplayName("기본 구분자를 입력한 경우 피연산자들을 추출한다.")
    void extractOperands_test(String input, String firstValue, String secondValue, String thirdValue) {
        //given
        Extractor extractor = new Extractor(input);

        //when
        String[] operands = extractor.extractOperands();

        //then
        assertThat(operands).containsExactly(
                firstValue,
                secondValue,
                thirdValue
        );
    }
}
