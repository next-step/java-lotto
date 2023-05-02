package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("구입 금액만큼 로또를 발급한다")
    public void Lotto_Count() {
        Lottos lottos = new Lottos(14000);
        assertThat(lottos.getLottoCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("당첨 번호와 비교하여 몇 등인지(몇 개 일치하였는지) 계산한다")
    public void Lotto_Rank() {
        Lotto lotto = new Lotto(Set.of(1, 3, 5, 14, 22, 45));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getRank(winNumbers).isFirstRank()).isFalse();
        assertThat(lotto.getRank(winNumbers).isSecondRank()).isFalse();
        assertThat(lotto.getRank(winNumbers).isThirdRank()).isFalse();
        assertThat(lotto.getRank(winNumbers).isFourthRank()).isTrue();
    }

    @Test
    @DisplayName("해당 당첨 등수의 로또가 몇 장인지 계산한다")
    public void Lotto_RankCount() {
        Lotto lotto1 = new Lotto(Set.of(1, 3, 5, 14, 22, 45));
        Lotto lotto2 = new Lotto(Set.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 7, 8));
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lottos.getFirstRankCount(winNumbers)).isZero();
        assertThat(lottos.getSecondRankCount(winNumbers)).isOne();
        assertThat(lottos.getThirdRankCount(winNumbers)).isOne();
        assertThat(lottos.getFourthRankCount(winNumbers)).isOne();
    }

    @Test
    @DisplayName("총 수익률을 계산한다")
    public void Lotto_EarningRate() {
        Lotto lotto1 = new Lotto(Set.of(1, 3, 5, 14, 22, 45));
        Lotto lotto2 = new Lotto(Set.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 7, 8));
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lottos.getEarningRate(winNumbers)).isEqualTo(388.75);
    }
}
