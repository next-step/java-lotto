package nextstep.lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"''=true","1=false"}, delimiter = '=')
    @DisplayName("입력문자열의 empty 테스트")
    void isEmptyTest(String inputValue, boolean result){
        assertThat(ValidationUtils.isNullAndEmpty(inputValue)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력문자열의 null 테스트")
    void isNullTest(){
        assertThat(ValidationUtils.isNullAndEmpty(null)).isEqualTo(true);
    }
}
