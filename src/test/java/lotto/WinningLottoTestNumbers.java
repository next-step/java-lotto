package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTestNumbers {

    @Test
    @DisplayName("2등 당첨 : winningLotto랑 Lotto비교")
    void 당첨번호_확인_2등() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,8));
        int bonus = 7;
        WinningLotto match = new WinningLotto(winningLotto, bonus);
        assertThat(match.findRank(lotto))
                .isEqualTo(LottoRank.SECOND);

    }

    @Test
    @DisplayName("3등 당첨 : winningLotto랑 Lotto비교")
    void 당첨번호_확인_3등() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,8));
        int bonus = 7;
        WinningLotto match = new WinningLotto(winningLotto, bonus);
        assertThat(match.findRank(lotto))
                .isEqualTo(LottoRank.THIRD);

    }
}