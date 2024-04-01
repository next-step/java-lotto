package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {
    private List<Integer> winNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
    }

    @Test
    void 순위_1등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(LottoMatch.match(lotto, new WinningLotto(winNumbers, bonusNumber))).isEqualTo(Rank.FIRST);
    }

    @Test
    void 순위_2등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(LottoMatch.match(lotto, new WinningLotto(winNumbers, bonusNumber))).isEqualTo(Rank.SECOND);
    }

    @Test
    void 순위_3등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        assertThat(LottoMatch.match(lotto, new WinningLotto(winNumbers, bonusNumber))).isEqualTo(Rank.THIRD);
    }

    @Test
    void 순위_4등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
        assertThat(LottoMatch.match(lotto, new WinningLotto(winNumbers, bonusNumber))).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 순위_5등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        assertThat(LottoMatch.match(lotto, new WinningLotto(winNumbers, bonusNumber))).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 등수_안에_못_듬() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11));
        assertThat(LottoMatch.match(lotto, new WinningLotto(winNumbers, bonusNumber))).isEqualTo(Rank.NONE);
    }
}
