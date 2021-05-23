package step3.winning;

import step3.lotto.Lotto;
import step3.lotto.LottoCount;
import step3.winning.WinningNumbers;
import step3.winning.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    private WinningStatistics statistics;

    @BeforeEach
    void setUp() {
        LottoCount lottoCount = new LottoCount(14000);
        Lotto lotto = new Lotto(lottoCount);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        statistics = new WinningStatistics(lotto, winningNumbers, lottoCount);
    }

    @Test
    void calculateWinningResult() {
        LottoCount lottoCount = new LottoCount(14000);
        Lotto lottoList = new Lotto(lottoCount);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        statistics.calculateWinningResult(lottoList, winningNumbers);
        System.out.println(statistics.getWinningResults());
    }
}
