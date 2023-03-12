package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StrAdderTest {

    private StrAdder stradder = new StrAdder();
    @Test
    @DisplayName("커스텀 구분자 사용여부확인")
    void isCustomSeparatorUsedTest(){
        String numbers = "//;\n1;2;3";
        assertThat(stradder.isCustomSeparatorUsed(numbers)).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자 추출")
    void parseCustomSeparatorTest(){
        String numbers = "//;\n1;2;3";
        String separator = stradder.parseCustomSeparator(numbers);

        assertThat(separator).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자 사용시 입력숫자 추출")
    void customSeparatorNumbersParsingTest(){
        String numbers = "//;\n1;2;3";
        String[] expectedFactors = {"1", "2", "3"};

        assertThat(stradder.parseNumbers(numbers)).isEqualTo(expectedFactors);
    }

    @Test
    @DisplayName("null 또는 빈문자 계산 테스트")
    void nullOrEmptyTest(){
        String factor = "";
        assertThat(stradder.adder(factor)).isEqualTo(0);

        factor = null;
        assertThat(stradder.adder(factor)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 한개 테스트")
    void singleFactorTest(){
        String factors = "1";
        assertThat(stradder.adder(factors)).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자 테스트")
    void commaSeparatorTest(){
        String factors = "1,2";
        assertThat(stradder.adder(factors)).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표,콜론 테스트")
    void commaAndSemicolonTest(){
        String factors = "1,2:3";
        assertThat(stradder.adder(factors)).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자(;) 계산 테스트 ")
    void adderTest(){
        String factors = "//;\n1;2;3";
        assertThat(stradder.adder(factors)).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 예외처리 테스트")
    void minusExceptionTest(){
        String factors = "-1,2,3";
        assertThatThrownBy(()->{
            stradder.adder(factors);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 아닌값 예외처리 테스트")
    void notNumberFactorExceptionTest(){
        String factors = "ㅂㅂ,1,2,3";
        assertThatThrownBy(()->{
            stradder.adder(factors);
        }).isInstanceOf(RuntimeException.class);
    }

}