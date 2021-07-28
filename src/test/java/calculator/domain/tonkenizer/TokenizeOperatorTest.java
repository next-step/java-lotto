package calculator.domain.tonkenizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class TokenizeOperatorTest {

    @DisplayName(",로 분리되는 input string이 들어오면 DefaultTokenizer를 사용하여 split후에 String 배열을 리턴한다")
    @ValueSource(strings = {"1,2,3", "1:2:3"})
    @ParameterizedTest
    public void should_return_default_token_string_array(String input) throws Exception {
        //act
        String[] result = TokenizeOperator.split(input);
        
        //assert
        assertThat(result).containsAll(Arrays.asList("1", "2", "3"));
    }

    @DisplayName("커스텀구분자로 input string이 들어오면 CustomTokenizer를 사용하여 split후에 String 배열을 리턴한다")
    @Test
    public void should_return_default_token_string_array() throws Exception {
        //arrange
        String input = "//-\n1-2-3";

        //act
        String[] result = TokenizeOperator.split(input);

        //assert
        assertThat(result).containsAll(Arrays.asList("1", "2", "3"));
    }

}