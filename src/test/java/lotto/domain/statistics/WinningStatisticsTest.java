package lotto.domain.statistics;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.number.LottoNumber;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResults;
import lotto.domain.result.NumberOfResults;
import lotto.domain.user.UserLotto;
import lotto.domain.user.UserLottos;
import lotto.domain.winning.WinningBalls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    private LottoResults lottoResults;
    private List<UserLotto> userLottos = new ArrayList<>();
    private WinningBalls winningBalls;
    private WinningStatistics winningStatistics;
    private NumberOfResults numberOfResults;

    @BeforeEach
    void setUp() {
        String[] numbers = {"1", "2", "3", "4", "40", "41"};
        List<Integer> candidates = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumber> lottoNumbers = candidates.stream().map(LottoNumber::new)
            .collect(Collectors.toList());

        winningBalls = new WinningBalls(numbers, "45");
        userLottos.add(new UserLotto(lottoNumbers));
        lottoResults = new LottoResults(userLottos, winningBalls);
    }

    @Test
    void 수익률테스트() {
        winningStatistics = new WinningStatistics(lottoResults, 14000);
        String profitRate = winningStatistics.applyProfitRate(
            winningStatistics.getNumberOfResults().getRawNumberOfResults(), 14000);

        assertThat(profitRate).isEqualTo("3.57");
    }

}
