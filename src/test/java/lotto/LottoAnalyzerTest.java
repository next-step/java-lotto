package lotto;

import lotto.model.Lotto;
import lotto.service.LottoAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoAnalyzerTest {

    @Test
    public void 당첨통계_계산() {
        List<Lotto> lottos = new ArrayList<>();

        lottos.add(new Lotto(new ArrayList<>(List.of(2, 5, 9, 10, 23, 31))));
        lottos.add(new Lotto(new ArrayList<>(List.of(2, 5, 16, 41, 18, 42))));

        List<Integer> winningNumbers = new ArrayList<>(List.of(2, 5, 9, 33, 35, 44));
        int bonusNumber = 16;

        assertThat(LottoAnalyzer.calculateWinningStatics(winningNumbers, bonusNumber, lottos)).isEqualTo(Map.of(1,0,2,0,3,0,4,0,5,1,0,1));
    }

    @Test
    public void 총수익률_계산() {
        assertThat(LottoAnalyzer.calculateReturnRate(10000, Map.of(1,0, 2,0, 3,0, 4,0, 5,1, 0,0))).isEqualTo(0.5f);
    }

}
