package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSplitterTest {

    @Test
    @DisplayName("문자열을 숫자로 변환하는 테스트")
    void text_to_int() {
        List<Integer> texts = StringSplitter.splitText("1,2,3");
        assertThat(texts.size()).isEqualTo(3);
        assertEquals(1 , texts.get(0));
    }

    @Test
    @DisplayName("음수가 포함된 문자열 입력시 예외 발생 테스트")
    void negative_number_check() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            List<Integer> texts = StringSplitter.splitText("-1,2,3");
        }).withMessageMatching("문자열에 음수값이 포함되어 있습니다.");
    }

}
