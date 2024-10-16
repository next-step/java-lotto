package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.enums.Rank.FIRST_RANK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerLottoTest {

    public static final String DELIMITER = ",";

    @Test
    @DisplayName("로또가 들어오면 알맞은 Rank를 반환한다.")
    void 로또_매치() {
        Lotto lotto = new Lotto("7,8,9,4,5,6", DELIMITER);
        WinnerLotto winnerLotto = new WinnerLotto(lotto, new LottoNum(11));
        assertThat(winnerLotto.match(lotto)).isEqualTo(FIRST_RANK);
    }

    @Test
    @DisplayName("보너스 넘버가 없으면 false 반환")
    void 보너스_번호_없음() {
        Lotto lotto = new Lotto("7,8,9,4,5,6", DELIMITER);
        WinnerLotto winnerLotto = new WinnerLotto(lotto, new LottoNum(11));
        assertThat(winnerLotto.isMatchBonus(lotto)).isFalse();
    }

    @Test
    @DisplayName("보너스 넘버가 있으면 true 반환")
    void 보너스_번호_있음() {
        Lotto lotto = new Lotto("7,8,9,4,5,6", DELIMITER);
        WinnerLotto winnerLotto = new WinnerLotto(lotto, new LottoNum(7));
        assertThat(winnerLotto.isMatchBonus(lotto)).isTrue();
    }

    @Test
    @DisplayName("당첨 로또와 일치하는 개수 추출")
    void 당첨_로또와_일치하는_개수_추출() {
        Lotto lotto1 = new Lotto("7,8,9,4,5,6", DELIMITER);
        Lotto lotto2 = new Lotto("1,2,3,4,5,6", DELIMITER);
        WinnerLotto winnerLotto = new WinnerLotto(lotto1, new LottoNum(7));
        assertThat(winnerLotto.compareWinningNumber(lotto2)).isEqualTo(3);
    }
}