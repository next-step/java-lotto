package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    @DisplayName("일치하는 수에 따른 로또 티켓 개수를 구한다")
    void shouldReturnResult() {
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoMachine lottoMachine = new LottoMachine(lottos());

        EnumMap<MatchedNumbers, Long> result = lottoMachine.result(winningNumbers);

        for (MatchedNumbers matchedNumbers : result.keySet()) {
            Long count = result.get(matchedNumbers);
            assertThat(count).isEqualTo(1);
        }
    }

    @Test
    void shouldCalculateProfit() {
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoMachine lottoMachine = new LottoMachine(lottosMatchedWinningNumbers());
        lottoMachine.result(winningNumbers);

        int totalCost = 2000;
        long prize = MatchedNumbers.THREE.prize(1L);
        float profit = lottoMachine.profit(totalCost);

        assertThat(profit).isEqualTo((float) prize / totalCost);
    }

    private Lottos lottos() {
        return new Lottos(Arrays.asList(
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 7, 8))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9)))
        ));
    }

    private Lottos lottosMatchedWinningNumbers() {
        return new Lottos(Arrays.asList(
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 8, 9, 10))),
                new Lotto(new LottoNumbers(Arrays.asList(11, 12, 13, 14, 15, 16)))
        ));
    }
}