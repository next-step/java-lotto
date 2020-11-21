package calculator.utils;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class IntegerUtilsTest {

    @Test
    @DisplayName("나뉜 문자를 숫자로 바꾼다")
    void should_return_integer_type_from_string() {
        //Given
        List<String> values = Lists.newArrayList("1", "2", "3");

        //When
        List<Integer> integers = IntegerUtils.parsePositiveInt(values);

        //Then
        assertThat(integers).containsAll(Lists.newArrayList(1, 2, 3));
    }

    @Test
    @DisplayName("입력한 문자가 음수 이면, Exception을 반환한다.")
    void should_throw_illegal_argument_exception_when_is_negative_quantity() {
        //Given
        List<String> values = Lists.newArrayList("-1", "-2", "3");

        //When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> IntegerUtils.parsePositiveInt(values))
                .withMessage("not allow negative quantity");
    }
}
