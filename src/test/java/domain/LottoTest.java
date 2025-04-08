package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_번호가_6개_아니면_예외() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("numList의 size가 잘못되었습니다.");
    }

    @Test
    void 로또_번호가_null이면_예외() {
        assertThatThrownBy(() -> new Lotto(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("numList가 null이거나 비어있을수 없습니다.");
    }

    @Test
    void 로또_번호가_빈_리스트면_예외() {
        assertThatThrownBy(() -> new Lotto(Collections.emptyList()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("numList가 null이거나 비어있을수 없습니다.");
    }

    @Test
    void matchRank시_5개_맞고_bonusnumber_맞았을경우_SECOND() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7), 6);
        lotto.matchRank(winningNumbers);
        assertThat(lotto.getRank()).isEqualTo(Rank.SECOND);
    }
}
