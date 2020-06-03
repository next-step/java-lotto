package lotto.domain.prize;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottoAnalyzerTest {

    @Test
    void 일치개수별_당첨수를_확인한다() {
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer();
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        lottoAnalyzer.calculateWinningStatistics(Arrays.asList(Lotto.create()), winNumber);
        // 어떻게 테스트 코드를 짜야할지..
    }

}