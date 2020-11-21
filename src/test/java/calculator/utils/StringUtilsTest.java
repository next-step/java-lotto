package calculator.utils;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @ParameterizedTest
    @DisplayName("문자열을 구분자에 맞게 나눈다")
    @ValueSource(strings = {"1,2,3", "1:2,3", "//;\n1;2;3"})
    void should_return_divided_string(String value) {
        //Given & When
        List<String> values = StringUtils.splitString(value);

        //Then
        assertThat(values).containsAll(Lists.newArrayList("1", "2", "3"));
    }

}
