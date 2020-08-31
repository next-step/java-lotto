package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @Test
    void 음수가_들어올_때_테스트() {
        assertThatThrownBy(() -> new Numbers(new String[]{"-1", "1", "2"}))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 사용할 수 없습니다.");
    }

    @Test
    void 숫자_이외의_값이_들어올_때_테스트() {
        assertThatThrownBy(() -> new Numbers(new String[]{"가", "1", "2"}))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자 이외의 값을 입력할 수 없습니다.");
    }


}
