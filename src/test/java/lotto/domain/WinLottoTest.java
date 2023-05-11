package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoTest {

    @Test
    void 지난주당첨번호() {
        WinLotto winLotto = winLottoFixuture("1, 8, 11, 31, 41, 42");

        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(8);
        expectedNumbers.add(11);
        expectedNumbers.add(31);
        expectedNumbers.add(41);
        expectedNumbers.add(42);

        Numbers numbers = new Numbers(expectedNumbers);

        assertThat(winLotto.numbers()).isEqualTo(numbers);
    }

    @Test
    void 지난주당첨번호with보너스번호() {
        WinLotto winLotto = winLottoWithBonusFixuture("1, 3, 11, 13, 21, 23", 31);

        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(1);
        expectedNumbers.add(3);
        expectedNumbers.add(11);
        expectedNumbers.add(13);
        expectedNumbers.add(21);
        expectedNumbers.add(23);

        Numbers numbers = new Numbers(expectedNumbers);

        assertAll(
                () -> assertThat(winLotto.numbers()).isEqualTo(numbers),
                () -> assertThat(winLotto.bonusNumber()).isEqualTo(31)
        );
    }

    @Test
    void 당첨() {
        WinLotto winLotto = winLottoFixuture("31, 32, 33, 34, 35, 36");
        Rank rank1 = lottoFixuture("31, 32, 33, 34, 35, 36").checkMatchingNumbers(winLotto);
        Rank rank2 = lottoFixuture("11, 32, 33, 34, 35, 36").checkMatchingNumbers(winLotto);
        assertAll(
                () -> assertThat(rank1).isEqualTo(Rank.FIRST),
                () -> assertThat(rank2).isEqualTo(Rank.THIRD)
        );
    }

    @Test
    void 미당첨() {
        WinLotto winLotto = winLottoFixuture("31, 32, 33, 34, 35, 36");
        Lotto lotto = new Lotto(new Numbers(InputView.makeNumbers("11, 12, 13, 14, 35, 36")));
        Rank rank = lotto.checkMatchingNumbers(winLotto);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @Test
    void 당첨_2등() {
        WinLotto winLotto = winLottoWithBonusFixuture("31, 32, 33, 34, 35, 36", 11);
        Rank rank = new Lotto(new Numbers(InputView.makeNumbers("11, 32, 33, 34, 35, 36"))).checkMatchingNumbers(winLotto);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    private Lotto lottoFixuture(String input) {
        return new Lotto(new Numbers(InputView.makeNumbers(input)));
    }

    private WinLotto winLottoFixuture(String input) {
        return new WinLotto(new Numbers(InputView.makeNumbers(input)));
    }

    private WinLotto winLottoWithBonusFixuture(String input, int bonusNumber) {
        return new WinLotto(new Numbers(InputView.makeNumbers(input)), bonusNumber);
    }
}
