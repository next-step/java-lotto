package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTest {

    @Test
    void 보너스번호_범위_검증_예외() {

        assertThatThrownBy(
                () -> new Winning(Set.of(1, 2, 3, 4, 5, 6).stream().map(number -> new LottoNumber(number)).collect(Collectors.toSet()), new LottoNumber(66))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_중복_검증_예외() {
        assertThatThrownBy(
                () -> new Winning(Set.of(1, 2, 3, 4, 5, 6).stream().map(number -> new LottoNumber(number)).collect(Collectors.toSet()), new LottoNumber(5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
