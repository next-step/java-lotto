package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    @Test
    void 로또_생성_시_범위_외_번호_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 66))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_갯수_검증() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 5, 6));

        assertAll(
                () -> assertThat(lotto.matchCount(Set.of(1, 43, 42, 30, 31, 33))).isEqualTo(1),
                () -> assertThat(lotto.matchCount(Set.of(1, 2, 3, 11, 12, 13))).isEqualTo(3),
                () -> assertThat(lotto.matchCount(Set.of(1, 2, 3, 5, 12, 13))).isEqualTo(4),
                () -> assertThat(lotto.matchCount(Set.of(1, 2, 3, 5, 12, 10))).isEqualTo(5),
                () -> assertThat(lotto.matchCount(Set.of(1, 2, 3, 10, 5, 6))).isEqualTo(6)
        );
    }

    @Test
    void 중복으로_입력으로_인한_사이즈_예외() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(10, 4, 9, 2, 4, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_맞았는지_검증() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        assertAll(
                () -> assertThat(lotto.isCollectBonusNumber(4)).isTrue(),
                () -> assertThat(lotto.isCollectBonusNumber(7)).isFalse()
        );
    }
}
