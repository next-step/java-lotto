package lotto.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankCalculatorTest {

    @DisplayName("내가 구매한 로또들이 몇 등의 몇 번 당첨됐는지 확인이 가능하다")
    @Test
    void calculateLottoRank(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 12, 13))
                , new Lotto(List.of(1, 2, 3, 4, 12, 13))
                , new Lotto(List.of(1, 2, 3, 4, 13, 14))
                , new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        LottoRankCalculator calculator = new LottoRankCalculator(lottos);
        EnumMap<LottoRank, Integer> rankInfo = calculator.calculateLottoRank(winningNumbers);

        assertThat(rankInfo.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(rankInfo.get(LottoRank.THIRD)).isEqualTo(2);
        assertThat(rankInfo.get(LottoRank.FIRST)).isEqualTo(1);
    }

}
