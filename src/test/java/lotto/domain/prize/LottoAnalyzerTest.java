package lotto.domain.prize;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAnalyzerTest {
    LottoAnalyzer lottoAnalyzer;

    @BeforeEach
    void setUp() {
        lottoAnalyzer = new LottoAnalyzer();
    }

    @Test
    void 일치개수별_당첨수를_확인한다() {

        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        lottoAnalyzer.calculateWinningStatistics(Arrays.asList(Lotto.create()), winNumber);
        // 어떻게 테스트 코드를 짜야할지..
    }

    @Test
    void 수익금을_계산한다() {
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        matchCountMap.put(3, 5);
        matchCountMap.put(4, 0);
        matchCountMap.put(5, 1);
        matchCountMap.put(6, 0);

        int winPrize = lottoAnalyzer.calculateWinPrize(matchCountMap);
        assertThat(winPrize).isEqualTo(1_525_000);

    }

    @Test
    void 수익율을_계산한다() {
        int purchaseAmount = 14000;
        int winPrize = 5000;

        double winRate = lottoAnalyzer.calculateWinRate(purchaseAmount, winPrize);

        assertThat(winRate).isEqualTo(0.35);
    }
}