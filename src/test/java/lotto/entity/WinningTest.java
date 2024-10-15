package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {

    @Test
    void 보너스번호_범위_검증_예외() {

        assertThatThrownBy(
                () -> new Winning(Set.of(1, 2, 3, 4, 5, 6), 66)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_중복_검증_예외() {

        assertThatThrownBy(
                () -> new Winning(Set.of(1, 2, 3, 4, 5, 6), 5)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
