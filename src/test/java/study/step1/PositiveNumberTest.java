package study.step1;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step1.domain.PositiveNumber;

public class PositiveNumberTest {

    @Test
    @DisplayName("생성 테스트")
    public void create() {
        PositiveNumber number = new PositiveNumber("0");
        assertThat(number).isEqualTo(new PositiveNumber("0"));
    }

    @Test
    @DisplayName("숫자 이외의 값 Exception Test")
    public void valid() {
        assertThatThrownBy(() -> new PositiveNumber("-1"))
            .isInstanceOf(RuntimeException.class);
    }
}
