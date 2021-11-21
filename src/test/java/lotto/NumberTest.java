package lotto;

import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    @DisplayName("45")
    void checkBoundTest() {
        int boundNumber = 46;
        assertThatThrownBy(() -> {
            new Number(boundNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("45보다 큰 숫자가 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("Number 클래스 equal 테스트")
    void numberTest() {
        assertThat(new Number(10)).isEqualTo(new Number(10));
    }
}
