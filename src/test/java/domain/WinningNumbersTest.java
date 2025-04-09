package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumbersTest {
    @Test
    void 당첨번호가_빈_리스트이면_예외() {
        assertThatThrownBy(() -> new WinningNumbers(Collections.emptyList(), 7))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("winningNumberList는 null이거나 비어있을 수 없습니다.");
    }

    @Test
    void 당첨번호가_6개가_아니면_예외() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5), 7))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("winningNumberList의 사이즈가 잘못되었습니다.");
    }
}
