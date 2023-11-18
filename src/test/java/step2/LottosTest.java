package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    public void 당첨_통계_계산하기() {
        Lottos lottos = new Lottos(
                new int[]{1, 2, 3, 4, 5, 6}, //1등 당첨 로또
                new int[]{1, 2, 9, 10, 11, 12}, //2개 당첨 -> 꼴등 당첨 로또
                new int[]{7, 8, 9, 10, 11, 12} //꼴등 당첨 로또
        );
        Lotto winnerLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6}); //우승 당첨 로또

        assertThat(lottos.calculateTotalRank(winnerLotto))
                .containsExactly(LottoRank.FIRST_PRIZE, LottoRank.NO_PRIZE, LottoRank.NO_PRIZE);
    }
}
