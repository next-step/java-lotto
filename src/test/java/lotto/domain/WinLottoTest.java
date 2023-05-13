package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoTest {

    @Test
    void 지난주당첨번호() {
        WinLotto winLotto = winLottoFixture("1, 8, 11, 31, 41, 42");

        List<Integer> expectedNumbers = Arrays.asList(1,8,11,31,41,42);
        Numbers numbers = new Numbers(expectedNumbers);

        assertThat(winLotto.numbers()).isEqualTo(numbers);
    }

    @Test
    void 지난주당첨번호with보너스번호() {
        WinLotto winLotto = winLottoWithBonusFixture("1, 3, 11, 13, 21, 23", 31);

        List<Integer> expectedNumbers = Arrays.asList(1,3,11,13,21,23);
        Numbers numbers = new Numbers(expectedNumbers);

        assertAll(
                () -> assertThat(winLotto.numbers()).isEqualTo(numbers),
                () -> assertThat(winLotto.bonusNumber()).isEqualTo(31)
        );
    }

    @Test
    void 당첨() {
        WinLotto winLotto = winLottoFixture("31, 32, 33, 34, 35, 36");
        Rank rank1 = winLotto.checkRank(lottoFixture("31, 32, 33, 34, 35, 36"));
        Rank rank2 = winLotto.checkRank(lottoFixture("11, 32, 33, 34, 35, 36"));
        assertAll(
                () -> assertThat(rank1).isEqualTo(Rank.FIRST),
                () -> assertThat(rank2).isEqualTo(Rank.THIRD)
        );
    }

    @Test
    void 미당첨() {
        WinLotto winLotto = winLottoFixture("31, 32, 33, 34, 35, 36");
        Rank rank = winLotto.checkRank(lottoFixture("11, 12, 13, 14, 35, 36"));
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @Test
    void 당첨_2등() {
        WinLotto winLotto = winLottoWithBonusFixture("31, 32, 33, 34, 35, 36", 11);
        Rank rank = winLotto.checkRank(lottoFixture("11, 32, 33, 34, 35, 36"));
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    private Lotto lottoFixture(String input) {
        return new Lotto(new Numbers(InputView.makeNumbers(input)));
    }

    private WinLotto winLottoFixture(String input) {
        return new WinLotto(new Numbers(InputView.makeNumbers(input)));
    }

    private WinLotto winLottoWithBonusFixture(String input, int bonusNumber) {
        return new WinLotto(new Numbers(InputView.makeNumbers(input)), bonusNumber);
    }
}
