package lotto;

import lotto.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @Test
    void create() {
        Numbers lotto = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Numbers win = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.sumContainsCount(win)).isEqualTo(6);
    }

    @DisplayName("6개 이외의 숫자 입력시 예외를 반환하다.")
    @Test
    void invalid_5개숫자() {
        assertThatThrownBy(() -> {
            new Numbers(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 숫자 입력시 예외를 반환하다.")
    @Test
    void invalid_중복숫자() {
        assertThatThrownBy(() -> {
            new Numbers(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
