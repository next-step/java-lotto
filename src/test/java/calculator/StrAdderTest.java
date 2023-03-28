package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StrAdderTest {

    private StrAdder stradder = new StrAdder();
    @Test
    @DisplayName("커스텀 구분자 사용여부확인")
    void isCustomUseTest(){
        String numbers = "//;\n1;2;3";
        assertThat(stradder.isCustomUse(numbers)).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자 추출")
    void parseCustomSeparatorTest(){
        String numbers = "//;\n1;2;3";
        String separator = stradder.parseCustom(numbers);

        assertThat(separator).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자 사용시 입력숫자 추출(4번째)")
    void customSeparatorNumbersParsingTest(){
        String numbers = "//;\n1;2;3";
        String[] expectedFactors = {"1", "2", "3"};

        assertThat(stradder.parseNumbers(numbers)).isEqualTo(expectedFactors);
    }

    @Test
    @DisplayName("커스텀 구분자(;) 계산 테스트 ")
    void adderTest(){
        String factors = "//;\n1;2;3";
        assertThat(stradder.adder(factors)).isEqualTo(6);
    }

    @Test
    @DisplayName("일반테스트 1 : 음수 예외처리 테스트")
    void minusExceptionTest(){
        String factors = "-1,2,3";
        assertThatThrownBy(()->{
            stradder.adder(factors);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("일반테스트 2 : 숫자 아닌값 예외처리 테스트")
    void notNumberFactorExceptionTest(){
        String factors = "ㅂㅂ,1,2,3";
        assertThatThrownBy(()->{
            stradder.adder(factors);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력문자열 테스트1 : null 또는 빈문자 계산 테스트")
    void nullTest(){
        String factor = "";
        assertThat(stradder.adder(factor)).isEqualTo(0);

        factor = null;
        assertThat(stradder.adder(factor)).isEqualTo(0);
    }

    @Test
    @DisplayName("입력문자열 테스트2 : 숫자 한개 테스트")
    void numberTest(){
        String factors = "1";
        assertThat(stradder.adder(factors)).isEqualTo(1);
    }

    @Test
    @DisplayName("입력문자열 테스트3 : 컴마 테스트")
    void commaTest(){
        String factors = "1,2";
        assertThat(stradder.adder(factors)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력문자열 테스트4 : 컴마,콜론 테스트")
    void commaColonTest(){
        String factors = "1,2:3";
        assertThat(stradder.adder(factors)).isEqualTo(6);
    }



}