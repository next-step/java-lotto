package lotto;

import lotto.common.ErrorMessage;
import lotto.utils.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringUtilsTest {

    @ParameterizedTest
    @DisplayName("문자열을 구분자에 맞게 나눈다")
    @ValueSource(strings = {"1,2,3", "1:2,3", "//;\n1;2;3"})
    void should_return_divided_string(String value) {
        //Given & When
        List<String> values = StringUtils.splitString(value);

        //Then
        assertThat(values).containsAll(Lists.newArrayList("1", "2", "3"));
    }

    @ParameterizedTest
    @DisplayName("빈 문자열 입력하면, Exception을 반환한다")
    @ValueSource(strings = {"", " "})
    void should_return_zero_when_is_blank(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtils.splitString(value))
                .withMessage(ErrorMessage.WINNING_NUMBER_ERROR);
    }
}
