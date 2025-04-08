import Lotto.domain.Lotto;
import Lotto.domain.LottoNumber;
import Lotto.domain.Lottos;
import Lotto.domain.ResultStats;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultStatsTest {

    @Test
    void calculateProfitRate_ShouldReturnCorrectRate() {
        List<LottoNumber> matchedNumbers = List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)
        );
        Lotto matchedLotto = new Lotto(matchedNumbers);

        List<Lotto> testLottos = List.of(matchedLotto);  // 1개만 구매한 상황
        Lottos lottos = new Lottos(testLottos);

        Set<LottoNumber> winningNumbers = Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );

        ResultStats stats = new ResultStats(lottos.getLottos(), winningNumbers);
        double profitRate = stats.calculateProfitRate(1000);  // 1장 구매

        assertEquals(5000.0 / 1000, profitRate, 0.01);

    }
}
