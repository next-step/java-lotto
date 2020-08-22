package calculator.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTest {

    @Test
    @DisplayName("문자열을 숫자로 변환하는 테스트")
    void text_To_Int_Test(){
        String[] texts = {"1", "2", "3"};
        List<Integer> numbers = StringUtil.textToInt(texts);

        assertThat(numbers.size()).isEqualTo(3);
        assertEquals(1 , numbers.get(0));
    }

    @Test
    @DisplayName("음수가 포함된 문자열 입력시 예외 발생")
    void negative_number_check_test(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            String[] texts = {"-1", "2", "3"};
            StringUtil.textToInt(texts);
        });
    }

}
