package calculate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserInputTest {

    @DisplayName("사용자 입력 파싱 : 구분자")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3:;", "//,\\n ,2,,4:,"}, delimiter = ':')
    public void parse_delimiter(String input, String expect) throws Exception {
        //given
        UserInput userInput = new UserInput(input);
        Assertions.assertThat(userInput.getDelimiter()).isEqualTo(expect);
    }

    @DisplayName("사용자 입력 파싱 : 피연산자")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3:1;2;3", "//,\\n2,, ,4:2,, ,4"}, delimiter = ':')
    public void parse_operand(String input, String expect) throws Exception {
        //given
        UserInput userInput = new UserInput(input);
        Assertions.assertThat(userInput.getPrimaloperand()).isEqualTo(expect);
    }

}
