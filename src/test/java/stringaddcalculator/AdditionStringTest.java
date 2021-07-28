package stringaddcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AdditionStringTest {
    @ValueSource(strings = {
            "1,:3,4,2",     // 숫자 이외
            "1;3,4,2",      // 숫자 이외
            "1,2,3,-1,4"    // 음수
    })
    @ParameterizedTest
    public void intValue_숫자이외_음수(String value) {

    }

    @Test
    public void intValue_빈문자열_Null() {

    }

    @ValueSource(strings = {
            "1",
            "12",
            "123"
    })
    @ParameterizedTest
    public void intValue_숫자하나(String value) {

    }

    @CsvSource(value = {
            "1:3,4,2=10"
    }, delimiter = '=')
    @ParameterizedTest
    public void intValue_구분자_콜론(String value, int result) {

    }

    @Test
    public void intValue_커스텀구분자() {

    }
}
