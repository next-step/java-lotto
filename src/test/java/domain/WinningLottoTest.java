package domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class WinningLottoTest {

    Lotto lotto;
    LottoNumber bonus;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonus = new LottoNumber(7);
    }

    @Test
    @DisplayName("로또와 보너스 로또 번호로 당첨 로또를 생성한다.")
    void createSuccess() {
        /* given */

        /* when & then */
        assertDoesNotThrow(() -> new WinningLotto(lotto, bonus));
    }

    @Test
    @DisplayName("로또의 로또 번호와 보너스 로또 번호가 중복될 경우 IllegalArgumentException을 던진다.")
    void createFailWithDuplicatedNumber() {
        /* given */
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = new LottoNumber(3);

        /* when & then */
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또와 당첨 로또 사이에 일치하는 로또 번호가 6개이면 1등이다.")
    void checkLottoResultFirstRank() {
        /* given */
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        /* when */
        Rank lottoResult = winningLotto.resolveRank(target);

        /* then */
        assertThat(lottoResult).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("로또와 당첨 로또 사이에 일치하는 로또 번호가 5개이고, 보너스 번호가 일치하면 2등이다.")
    void checkLottoResultSecondRank() {
        /* given */
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        /* when */
        Rank lottoResult = winningLotto.resolveRank(target);

        /* then */
        assertThat(lottoResult).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("로또와 당첨 로또 사이에 일치하는 로또 번호가 5개이면 3등이다.")
    void checkLottoResultThirdRank() {
        /* given */
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        /* when */
        Rank lottoResult = winningLotto.resolveRank(target);

        /* then */
        assertThat(lottoResult).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("로또와 당첨 로또 사이에 일치하는 로또 번호가 4개이면 4등이다.")
    void checkLottoResultFourthRank() {
        /* given */
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 44, 45));
        Lotto targetWithBonus = new Lotto(List.of(1, 2, 3, 4, 7, 45));

        /* when */
        Rank lottoResult = winningLotto.resolveRank(target);
        Rank lottoResultWithBonus = winningLotto.resolveRank(targetWithBonus);

        /* then */
        assertThat(lottoResult).isEqualTo(Rank.FOURTH);
        assertThat(lottoResultWithBonus).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("로또와 당첨 로또 사이에 일치하는 로또 번호가 3개이면 5등이다.")
    void checkLottoResultFifthRank() {
        /* given */
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        Lotto target = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Lotto targetWithBonus = new Lotto(List.of(1, 2, 3, 7, 44, 45));

        /* when */
        Rank lottoResult = winningLotto.resolveRank(target);
        Rank lottoResultWithBonus = winningLotto.resolveRank(targetWithBonus);

        /* then */
        assertThat(lottoResult).isEqualTo(Rank.FIFTH);
        assertThat(lottoResultWithBonus).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("로또와 당첨 로또 사이에 일치하는 로또 번호가 3개 미만이면 꽝이다.")
    void checkLottoResultNoneRank() {
        /* given */
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        Lotto target = new Lotto(List.of(1, 2, 42, 43, 44, 45));
        Lotto targetWithBonus = new Lotto(List.of(1, 2, 7, 43, 44, 45));

        /* when */
        Rank lottoResult = winningLotto.resolveRank(target);
        Rank lottoResultWithBonus = winningLotto.resolveRank(targetWithBonus);

        /* then */
        assertThat(lottoResult).isEqualTo(Rank.NONE);
        assertThat(lottoResultWithBonus).isEqualTo(Rank.NONE);
    }

}
