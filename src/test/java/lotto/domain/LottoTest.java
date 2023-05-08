package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @Test
    void 로또자동발급확인() {
        Lotto lotto = Lotto.autoGenerate();
        assertThat(lotto.numbers().getValues().size()).isEqualTo(6);
        assertAll(
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(0))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(1))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(2))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(3))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(4))).isTrue(),
                () -> assertThat(LottoRule.NUMBER_RANGE.contains(lotto.numbers().find(5))).isTrue()
        );
    }

    @Test
    void 당첨() {
        WinLotto winLotto = new WinLotto(new Numbers(InputView.makeNumbers("31, 32, 33, 34, 35, 36")));
        Rank rank1 = new Lotto(new Numbers(InputView.makeNumbers("31, 32, 33, 34, 35, 36"))).checkMatchingNumbers(winLotto);
        Rank rank2 = new Lotto(new Numbers(InputView.makeNumbers("11, 32, 33, 34, 35, 36"))).checkMatchingNumbers(winLotto);
        assertAll(
                () -> assertThat(rank1).isEqualTo(Rank.FIRST),
                () -> assertThat(rank2).isEqualTo(Rank.THIRD)
        );
    }

    @Test
    void 미당첨() {
        WinLotto winLotto = new WinLotto(new Numbers(InputView.makeNumbers("31, 32, 33, 34, 35, 36")));
        Lotto lotto = new Lotto(new Numbers(InputView.makeNumbers("11, 12, 13, 14, 35, 36")));
        Rank rank = lotto.checkMatchingNumbers(winLotto);
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
