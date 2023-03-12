package stringpluscalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringPlusCalculatorTest {

    StringPlusCalculator stringPlusCalculator;
    Number number;

    @BeforeEach
    void init() {
        stringPlusCalculator = new StringPlusCalculator();
        number = new Number("1");
    }

    @DisplayName("쉼표(,)나 콜론(:)으로 분리해 각 숫자의 합을 반환")
    @ParameterizedTest(name = "{displayName} [{index}]")
    @CsvSource({"'1:2:3', 6"
            , "'2:3:5', 10"
            , "'1:5:9', 15"
            , "'2:7:235', 244"
            , "'2,3,5', 10"
            , "'1,5,9', 15"
            , "'2,7,235', 244"
    })
    void addByCommaOrColon(String str, int expect) {
//        assertThat(stringPlusCalculator.addByCommaOrColon(str)).isEqualTo(expect);
        assertThat(stringPlusCalculator.addByDelimiter(str)).isEqualTo(expect);
    }


    @DisplayName("커스텀 구분자가 있는지 확인")
    @ParameterizedTest(name = "{displayName} [{index}]")
    @CsvSource({"'//:\n1:2:3', true"
            , "'//:\n2:3:5', true"
            , "'//an1:5:9', false"
            , "'//:\n2:7:235', true"
    })
    void checkCustomDelimiter(String str, boolean expect) {
        assertTrue(stringPlusCalculator.checkCustomDelimiter(str) == expect);
    }

    @Test
    @DisplayName("pattern matcher 테스트")
    void checkCustomDelimiter2() {
        String str = "//:\n1:2:3";

//        Pattern pattern = Pattern.compile("//(.*)\n(.*)");
        Pattern pattern = Pattern.compile("//(.*)\n(.*)");
        Matcher matcher= pattern.matcher(str);

        System.out.println(matcher.find());
        System.out.println(matcher.groupCount());
        System.out.println("======================");
        for(int i=0; i<matcher.groupCount(); i++) {
            System.out.println("group["+(i+1)+"]="+matcher.group(i+1));
        }
        System.out.println("======================");
    }

    @DisplayName("커스텀 구분자로 분리해 각 숫자의 합을 반환")
    @ParameterizedTest(name = "{displayName} [{index}]")
    @CsvSource({"'//:\n1:2:3', 6"
            , "'//:\n2:3:5', 10"
            , "'//:\n2:7:235', 244"
            , "'//@\n2@7@235', 244"
            , "'//@\n2@7@235', 244"
    })
    void addByCustomDelimiter(String str, int expect) {
//        assertThat(stringPlusCalculator.addByCustomDelimiter(str)).isEqualTo(expect);
        assertThat(stringPlusCalculator.addByDelimiter(str)).isEqualTo(expect);
    }

    @DisplayName("0을 포함한 자연수 이외의 값이 있는경우 RuntimeException 예외를 throw")
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4","123","0","2384"})
    void validNumber(String stringNumber) {
        number.validNumber(stringNumber);
    }

    @DisplayName("0을 포함한 자연수 이외의 값이 있는경우 RuntimeException 예외를 throw")
    @ParameterizedTest
    @ValueSource(strings = {"-1","er","a3","-dsf","-df123","-0","2a384"})
    void validNumber2(String stringNumber) {
        assertThrowsExactly(RuntimeException.class, ()->number.validNumber(stringNumber));
    }


}
