package lotto;

import lotto.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @DisplayName("당첨된 번호의 총숫자를 반환한다")
    @Test
    void create() {
        Numbers lotto = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Numbers win = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.sumContainsCount(win)).isEqualTo(6);
    }

    @DisplayName("6개 이외의 숫자 입력시 예외를 반환하다.")
    @Test
    void invalid_6이외숫자() {
        assertThatThrownBy(() -> {
            new Numbers(Arrays.asList(1, 2, 3, 4, 5));
            new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
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
