import Lotto.domain.LottoNumber;
import Lotto.domain.Lottos;
import Lotto.domain.Lotto;
import Lotto.domain.ResultStats;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

public class LottoGameTest {
    @Test
    void calculateProfitRate_ShouldReturnCorrectRate() {
        // given
        Lottos lottoList = new Lottos(0); // 생성 시 자동으로 생성되는 로또 무시

        // 당첨 번호: 1, 2, 3, 4, 5, 6
        Set<LottoNumber> winningNumbers = Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );

        // 수동으로 하나의 로또만 추가: 1, 2, 3, 7, 8, 9 (3개 일치 → 5등 5,000원)
        lottoList.addLotto(new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)
        )));

        ResultStats resultStats = new ResultStats(lottoList.getLottos(), winningNumbers);

        // when
        int totalSpent = 1000; // 로또 한 장 구매
        double profitRate = resultStats.calculateProfitRate(totalSpent);

        // then
        assertEquals(5.0, profitRate, 0.01); // 5,000 / 1,000 = 5.0
    }
}
