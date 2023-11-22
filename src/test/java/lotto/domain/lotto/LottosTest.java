package lotto.domain.lotto;

import lotto.constants.Winning;
import lotto.domain.summary.Summary;
import lotto.domain.summary.WinningSummary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {
    @Test
    @DisplayName("입력한 금액만큼의 로또를 생성한다. 금액이 부족한 경우 예외가 발생한다")
    public void create_by_price() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(Lottos.of(10000, () -> list).size()).isEqualTo(10);
        assertThatThrownBy(() -> Lottos.of(900, () -> list)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동으로 로또를 생성한다. 로또번호가 1~45 숫자가 아니거나 6자리가 아니거나 빈값인 경우 예외가 발생한다.")
    public void create_manual() {
        List<Lotto> list = List.of(
                Lotto.of(1, 2, 3, 4, 5, 6),
                Lotto.of(7, 8, 9, 10, 11, 12),
                Lotto.of(13, 14, 15, 16, 17, 18)
        );

        assertThat(Lottos.of(list).size()).isEqualTo(3);
        assertThatThrownBy(() -> Lottos.of(List.of(Lotto.of(1, 2, 3, 4, 5)))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Lottos.of(List.of(Lotto.of(1, 2, 3, 4, 5, 46)))).isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> Lottos.of(List.of(Lotto.of(1, 2, 3, 4, 5, 6, 7)))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 통계를 조회한다. 각 등수별 당첨수와 수익률을 반환한다")
    public void summary() {
        Lottos lottos = Lottos.of(10000, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto jackpot = Lotto.of(Arrays.asList(1, 2, 3, 4, 30, 40));
        Summary match = lottos.match(jackpot, LottoNumber.of(20));

        WinningSummary winningSummary = WinningSummary.newInstance();
        winningSummary.addWinning(Winning.FOURTH, 10L);

        assertThat(match).isEqualTo(new Summary(winningSummary, 10000L));
    }

    @Test
    @DisplayName("로또 목록 2개를 합치고 각 등수별 당첨수와 수익률을 반환한다")
    public void merge_summary() {
        Lottos lottosA = Lottos.of(10000, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottosB = Lottos.of(10000, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos mergedLottos = Lottos.concat(lottosA, lottosB);
        Lotto jackpot = Lotto.of(Arrays.asList(1, 2, 3, 4, 30, 40));

        Summary match = mergedLottos.match(jackpot, LottoNumber.of(20));

        WinningSummary winningSummary = WinningSummary.newInstance();
        winningSummary.addWinning(Winning.FOURTH, 20L);

        assertThat(match).isEqualTo(new Summary(winningSummary, 20000L));
    }
}
