package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.data.LottoNumbers;
import lotto.data.Lottos;
import lotto.data.Rank;

class WinnersTest {
    private Winners winners;

    @Test
    void sort_grade() {
        Lottos lottos = lottoGenerate(10);
        LottoNumbers winner = winnerGenerate(0);
        winners = new Winners(lottos, winner);

        assertThat(winners.getResult().get(Rank.FIRST)).isEqualTo(1);
        assertThat(winners.getResult().get(Rank.FIFTH)).isEqualTo(1);
        assertThat(winners.getResult().get(Rank.MISS)).isEqualTo(5);
    }

    @Test
    void total_earning() {
        Lottos lottos = lottoGenerate(2);
        LottoNumbers winner = winnerGenerate(0);
        winners = new Winners(lottos, winner);

        assertThat(winners.totalEarning()).isEqualTo(Rank.FIRST.getPrize() + Rank.SECOND.getPrize());
    }

    @Test
    void match_bonus() {
        Lottos lottos = lottoGenerate(10);
        LottoNumbers winner = winnerGenerate(0);
        int bonus = 7;
        winners = new Winners(lottos, winner, bonus);

        assertThat(winners.getResult().get(Rank.SECOND)).isEqualTo(1);
    }

    private LottoNumbers winnerGenerate(int weight) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < 7; i ++) {
            numbers.add(i + weight);
        }

        return new LottoNumbers(numbers);
    }

    private Lottos lottoGenerate(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 1; j < 7 ; j ++) {
                numbers.add(i + j);
            }
            lottos.add(new Lotto(new LottoNumbers(numbers)));
        }

        return new Lottos(lottos);
    }
}
