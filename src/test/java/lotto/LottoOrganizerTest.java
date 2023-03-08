package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.LottoOrganizer.LottoGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoOrganizerTest {

    @DisplayName("금액을 입력하면 금액만큼의 로또를 반환한다.")
    @Test
    void lottoPurchaseTest() {
        int money = 14500;
        List<Lotto> actual = LottoOrganizer.purchase(money);
        assertThat(actual.size()).isEqualTo(14);
    }

    @DisplayName("입력된 로또의 1등 당첨을 확인한다.")
    @Test
    void lottoPrizeFirstTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winnerNum = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoGrade actual = LottoOrganizer.checkLotto(lotto, winnerNum, 8);
        assertThat(actual).isEqualTo(LottoGrade.FIRST);
    }

    @DisplayName("입력된 로또의 2등 당첨을 확인한다.")
    @Test
    void lottoPrizeSecondTest() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        List<Integer> winnerNum = Arrays.asList(1, 2, 3, 4, 5, 10);

        LottoGrade actual = LottoOrganizer.checkLotto(lotto, winnerNum, 8);
        assertThat(actual).isEqualTo(LottoGrade.SECOND);
    }

    @DisplayName("입력된 로또의 3등 당첨을 확인한다.")
    @Test
    void lottoPrizeThirdTest() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winnerNum = Arrays.asList(1, 2, 3, 4, 5, 10);

        LottoGrade actual = LottoOrganizer.checkLotto(lotto, winnerNum, 8);
        assertThat(actual).isEqualTo(LottoGrade.THIRD);
    }

    @DisplayName("입력된 로또의 4등 당첨을 확인한다.")
    @Test
    void lottoPrizeFourthTest() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winnerNum = Arrays.asList(1, 2, 3, 4, 10, 20);

        LottoGrade actual = LottoOrganizer.checkLotto(lotto, winnerNum, 8);
        assertThat(actual).isEqualTo(LottoGrade.FOURTH);
    }

    @DisplayName("입력된 로또의 5등 당첨을 확인한다.")
    @Test
    void lottoPrizeFifthTest() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winnerNum = Arrays.asList(1, 2, 3, 10, 20, 30);

        LottoGrade actual = LottoOrganizer.checkLotto(lotto, winnerNum, 8);
        assertThat(actual).isEqualTo(LottoGrade.FIFTH);
    }

    @DisplayName("입력된 로또의 미당첨을 확인한다.")
    @Test
    void lottoPrizeNoneTest() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winnerNum = Arrays.asList(10, 11, 12, 13, 14, 1);

        LottoGrade actual = LottoOrganizer.checkLotto(lotto, winnerNum, 8);
        assertThat(actual).isEqualTo(LottoGrade.NO_GRADE);
    }

}
