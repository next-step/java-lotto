package calculator.domain;

import org.junit.jupiter.api.Test;

import static calculator.domain.InputValueProcessing.checkCustomDelimiter;
import static calculator.domain.InputValueProcessing.calculateInputValue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValueProcessingTest {
    @Test
    void isNull() {
        assertThat(calculateInputValue("")).isEqualTo(0);
        assertThat(calculateInputValue(null)).isEqualTo(0);
    }

    @Test
    void isOnly() {
        assertThat(calculateInputValue("3")).isEqualTo(3);
        assertThat(calculateInputValue("7")).isEqualTo(7);
    }

    @Test
    void 컴마로_구분() {
        assertThat(calculateInputValue("3,2")).isEqualTo(5);
    }

    @Test
    void 콜론으로_구분() {
        assertThat(calculateInputValue("3:2")).isEqualTo(5);
        assertThat(calculateInputValue("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_지정() {
        assertThat(calculateInputValue("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_체크() {
        assertThat(checkCustomDelimiter("//;\n1;2;3")).hasSize(3);
        assertThat(checkCustomDelimiter("//;\n1;2;3")).containsExactly("1", "2", "3");
    }

    @Test
    void 음수가_들어올_때_테스트() {
        assertThatThrownBy(() -> calculateInputValue("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 사용할 수 없습니다.");
    }

    @Test
    void 숫자_이외의_값이_들어올_때_테스트() {
        assertThatThrownBy(() -> calculateInputValue("가,1:2"))
                .isInstanceOf(RuntimeException.class);
    }
}
