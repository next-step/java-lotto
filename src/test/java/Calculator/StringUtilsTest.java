package Calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
        //given
    void checkEmtpyTrue(String input) {
        assertThat(StringUtils.checkEmpty(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource("1, |, ?")
        //given
    void checkEmptyFalse(String input) {
        assertThat(StringUtils.checkEmpty(input)).isFalse();
    }

    @Test
    void parseOperandTest() {
        //given
        String[] arr = {"1", "2", "-3"};
        int[] answer = {1, 2, -3};

        //when
        int[] result = StringUtils.parseToIntList(arr);

        //then
        assertThat(result).containsOnly(answer);
    }


    @Test
    void splitTest() {
        //given
        String str = "1:3,4";
        Delimiter delimiter = new Delimiter(":|,");

        //when
        String[] result = StringUtils.splitWithDelimiter(str, delimiter);
    }
}
