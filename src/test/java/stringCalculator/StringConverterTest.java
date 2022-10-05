package stringCalculator;

import org.junit.jupiter.api.Test;
import stringCalculator.utils.StringConverter;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StringConverterTest {

    private static final StringConverter stringConverter = new StringConverter();
    private static final String REGEX = " ";

    private static final String USER_INPUT = "1 + 2 * 3 - 4 / 1";

    @Test
    void 문자열_분해_테스트() {
        List<String> expected = Arrays.asList(USER_INPUT.split(REGEX));

        List<String> result = stringConverter.convertToList(USER_INPUT);
        assertThat(result).isEqualTo(expected);
    }

}
