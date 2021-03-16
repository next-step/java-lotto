package step1.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("토큰 일급컬렉션 테스트")
public class TokensTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2:3,3", "1:2,2"})
    @DisplayName("List<token> 생성확인 테스트")
    public void tokensCreateTest(String inputText, int size) throws Exception {
        //given
        Tokens tokens = new Tokens(inputText);

        //when
        List<Token> tokenList = tokens.getReadOnlyTokens();

        //then
        assertThat(tokenList.size()).isEqualTo(size);
    }

    @Test
    @DisplayName("커스텀구분자 List<token> 생성 테스트")
    public void tokensCreateTest() throws Exception {
        //given
        Tokens tokens = new Tokens("//;\n1;2;3");

        //when
        List<Token> tokenList = tokens.getReadOnlyTokens();

        //then
        assertThat(tokenList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("null 값일 때 0 토큰 반환 확인")
    public void zeroTokensTest() throws Exception {
        //given
        String inputText = null;
        Tokens tokens = new Tokens(inputText);

        //when
        List<Token> tokenList = tokens.getReadOnlyTokens();

        //then
        assertThat(tokenList.get(0).getToken()).isEqualTo(0);
    }

    @Test
    @DisplayName("빈공백일 때 0 토큰 반환 확인")
    public void emptyTokensTest() throws Exception {
        //given
        String inputText = "";
        Tokens tokens = new Tokens(inputText);

        //when
        List<Token> tokenList = tokens.getReadOnlyTokens();

        //then
        assertThat(tokenList.get(0).getToken()).isEqualTo(0);
    }
}
