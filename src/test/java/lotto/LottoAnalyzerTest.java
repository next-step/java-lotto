package lotto;

import lotto.model.Lotto;
import lotto.service.LottoAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoAnalyzerTest {

    @Test
    public void 당첨통계_계산() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto(new ArrayList<>(List.of(2, 5, 9, 10, 23, 31))));
        lottos.add(new Lotto(new ArrayList<>(List.of(6, 13, 26, 41, 18, 42))));

        List<Integer> winningNumbers = new ArrayList<>(List.of(2, 5, 9, 33, 35, 44));

        assertThat(LottoAnalyzer.calculateWinningStatics(winningNumbers, lottos)).isEqualTo(new int[]{1, 0, 0, 1, 0, 0, 0});
    }

    @Test
    public void 총수익률_계산() {
        assertThat(LottoAnalyzer.calculateReturnRate(10000, new int[]{0, 0, 0, 1, 0, 0, 0})).isEqualTo(0.5f);
    }

}
