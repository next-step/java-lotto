package step1.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("연산 테스트")
class OperatorText {
    Operator operator;

    @BeforeEach
    void setUp(){
        operator = new Operator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3,6", "100:5:5,110"})
    @DisplayName("문자열 합 테스트")
    void tokensTotalSumTest(String inputText, int sum) throws Exception {
        //given
        Tokens tokens = new Tokens(inputText);

        //when
        int result = operator.totalSum(tokens);

        //then
        assertThat(result).isEqualTo(sum);
    }

    @Test
    @DisplayName("문자열 null 결과 0 확인")
    void isNullOperatorTest() throws Exception {
        //given
        String inputText = null;
        Tokens tokens = new Tokens(inputText);

        //when
        int result = operator.totalSum(tokens);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 빈공백 결과 0 확인")
    void isEmptyOperatorTest() throws Exception {
        //given
        String inputText = "";
        Tokens tokens = new Tokens(inputText);

        //when
        int result = operator.totalSum(tokens);

        //then
        assertThat(result).isEqualTo(0);
    }
}
