package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;
import step2.model.Lotto;
import step2.model.LottoRank;
import step2.model.Lottos;

public class LottosTest {

    @Test
    public void 당첨_통계_계산하기() {
        Lottos lottos = new Lottos(
                new int[]{1, 2, 3, 4, 5, 6}, //1등 당첨 로또
                new int[]{1, 2, 9, 10, 11, 12}, //2개 당첨 -> 꼴등 당첨 로또
                new int[]{7, 8, 9, 10, 11, 12} //꼴등 당첨 로또
        );
        WinningLotto winnerLotto = new WinningLotto(new int[]{1, 2, 3, 4, 5, 6}, 7); //우승 당첨 로또

        assertThat(lottos.calculateTotalRank(winnerLotto))
                .containsExactlyInAnyOrderEntriesOf(Map.of(LottoRank.FIRST_PRIZE, 1L, LottoRank.NO_PRIZE, 2L));
    }
}
