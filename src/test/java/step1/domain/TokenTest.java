package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("토큰 테스트")
public class TokenTest {

    @Test
    @DisplayName("0 token 확인")
    public void zeroTokenTest() throws Exception {
        //given
        Token token = new Token();
        //when

        //then
        assertThat(token.getToken()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "0:0", "2:2"}, delimiter = ':')
    @DisplayName("문자열 token 확인")
    public void zeroTokenTest(String text, int number) throws Exception {
        //given
        Token token = new Token(text);
        //when

        //then
        assertThat(token.getToken()).isEqualTo(number);
    }

    @Test
    @DisplayName("음수 예외 테스트")
    public void minusTokenExceptionTest() throws Exception {
        //given

        //when, then
        assertThatThrownBy(() -> new Token("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
