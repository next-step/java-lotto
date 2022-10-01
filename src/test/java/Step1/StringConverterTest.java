package Step1;

import Step1.StringConverter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StringConverterTest {

    private static StringConverter stringConverter = new StringConverter();
    private static String REGEX = " ";

    @Test
    void 문자열_분해_테스트() {
        String userInput = "1 + 2 * 3 - 4 / 1";
        List<String> expected = Arrays.asList(userInput.split(REGEX));

        List<String> result = stringConverter.convertToList(userInput);
        assertThat(result).isEqualTo(expected);
    }

}
