package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step2.util.StringUtil.numbers;

public class StringUtilTest {

    @Test
    @DisplayName("문자열을 숫자 배열로 바꿀 수 있다")
    public void text_to_integer_list() {
        String text = "1, 2, 3, 4, 5, 6";
        assertThat(numbers(text)).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

}
