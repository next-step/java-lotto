package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(final String userInput) {
        Number number = new Number(userInput);
        assertThat(number.getNumber()).isEqualTo("0");
    }

    @DisplayName("빈 문자열 또는 null이 아닐경우 문자열을 반환")
    @ParameterizedTest
    @ValueSource(strings = {"123:456,789"})
    void 빈_문자열_또는_null_이_아닐경우_문자열을_반환(final String userInput) {
        Number number = new Number(userInput);
        assertThat(number.getNumber()).isEqualTo(userInput);
    }

    @DisplayName("사용자 입력으로 들어온 문자열에서 콤마(,),세미콜론(:)을 제거")
    @ParameterizedTest
    @ValueSource(strings = {"123,456:789"})
    void 사용자_입력으로_들어온_문자열에서_콤마_세미콜론_을_기준으로_자름(final String userInput){
        Number number = new Number(userInput);
        assertThat(number.split()).isEqualTo(Arrays.asList("123","456","789"));
    }
//    @DisplayName("들어온 문자열이 숫자로 변환할 수 있다.")
//    @ParameterizedTest
//    @ValueSource()
//    public void stringTransferNumber(){
//        stringcalculator.Number number = new stringcalculator.Number();
//        validate()
//    }

}
