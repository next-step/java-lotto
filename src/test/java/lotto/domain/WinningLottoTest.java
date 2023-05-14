package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {

    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 9);
    }

    @Test
    @DisplayName("[요구사항 1] 당첨 번호 6개와 모두 일치하는 복권을 사면 1등이다.")
    void 요구사항_1() {
        // given: 기대 되는 결과
        Rank expectedRank = Rank.FIRST_PLACE;

        // when: 로또 구입
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(winningLotto.calculateRank(lotto)).isEqualTo(expectedRank);
    }

    @Test
    @DisplayName("[요구사항 2] 로또 번호가 2개 일치하는 경우에는 보너스 숫자가 맞아도 LOST, 즉 꽝이다.")
    void 요구사항_2() {
        // given
        int winningCount = 2;
        boolean hasBonusNumber = true;

        // then
        assertThat(winningLotto.findRank(winningCount, hasBonusNumber)).isEqualTo(Rank.LOST);
    }

    @Test
    @DisplayName("[요구사항 3] 로또 번호가 5개 일치하고 보너스 숫자가 맞으면 2등이다.")
    void 요구사항_3() {
        // given
        int winningCount = 5;
        boolean hasBonusNumber = true;

        // then
        assertThat(winningLotto.findRank(winningCount, hasBonusNumber)).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    @DisplayName("[요구사항 4] 로또 번호가 5개 일치하지만 보너스 숫자가 틀리면 3등이다.")
    void 요구사항_4() {
        // given
        int winningCount = 5;
        boolean hasBonusNumber = false;

        // then
        assertThat(winningLotto.findRank(winningCount, hasBonusNumber)).isEqualTo(Rank.THIRD_PLACE);
    }

    @Test
    @DisplayName("[요구사항 5] 5등을 하려면 일치되는 개수가 3개여야 한다.")
    void 요구사항_5() {
        // given
        int winningCount = 3;
        Rank rank = Rank.FIFTH_PLACE;

        // then
        assertThat(winningLotto.isWinningCount(winningCount, rank)).isTrue();
    }

    @Test
    @DisplayName("[요구사항 6] 당첨 번호와 동일한 번호들을 가진 로또를 구입했을 때 일치되는 숫자는 6개이다.")
    void 요구사항_6() {
        // given: 기대 되는 결과
        int expectedMatchCount = 6;

        // when: 복권 당첨 번호와 같은 번호들을 가진 로또 구입
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(winningLotto.getMatchNumbers(lotto)).isEqualTo(expectedMatchCount);
    }
}