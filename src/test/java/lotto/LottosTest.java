package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottosTest {
    @Test
    @DisplayName("구입 금액은 로또 한 장 가격의 배수여야 한다")
    public void invalidMoney() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottos(14001));
    }

    @Test
    @DisplayName("해당 당첨 등수의 로또가 몇 장인지 계산한다")
    public void rankCount() {
        Lotto lotto1 = new Lotto(Set.of(1, 3, 5, 14, 22, 45));
        Lotto lotto2 = new Lotto(Set.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 7, 8));
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 4, 5, 6), 7);
        assertAll(
                () -> assertThat(lottos.getRankCount(winNumbers).get(Rank.FIRST)).isZero(),
                () -> assertThat(lottos.getRankCount(winNumbers).get(Rank.SECOND)).isOne(),
                () -> assertThat(lottos.getRankCount(winNumbers).get(Rank.THIRD)).isZero(),
                () -> assertThat(lottos.getRankCount(winNumbers).get(Rank.FOURTH)).isOne(),
                () -> assertThat(lottos.getRankCount(winNumbers).get(Rank.FIFTH)).isOne()
        );
    }

    @Test
    @DisplayName("총 수익률을 계산한다")
    public void earningRate() {
        Lotto lotto1 = new Lotto(Set.of(1, 3, 5, 14, 22, 45));
        Lotto lotto2 = new Lotto(Set.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 7, 8));
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 5, 8));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottos.getEarningRate(winNumbers)).isEqualTo(388.75);
    }

    @Test
    @DisplayName("이득인지 손해인지 확인한다")
    public void gainOrLoss() {
        Lotto lotto1 = new Lotto(Set.of(1, 3, 5, 14, 22, 45));
        Lotto lotto2 = new Lotto(Set.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 7, 8));
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 5, 8));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        WinNumbers winNumbers = new WinNumbers(Set.of(1, 2, 3, 4, 5, 6), 7);
        assertAll(
                () -> assertThat(lottos.isGain(winNumbers)).isTrue(),
                () -> assertThat(lottos.isLoss(winNumbers)).isFalse()
        );
    }
}
