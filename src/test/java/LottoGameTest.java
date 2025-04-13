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
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
        );

        // 수동으로 하나의 로또만 추가: 1, 2, 3, 7, 8, 9 (3개 일치 → 5등 5,000원)
        lottoList.add(new Lotto(List.of(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9)
        )));

        // 보너스 번호: 7
        LottoNumber bonusNumber = LottoNumber.of(7);

        ResultStats resultStats = new ResultStats(lottoList.getLottos(), winningNumbers, bonusNumber);

        // when
        int totalSpent = 1000; // 로또 한 장 구매
        double profitRate = resultStats.calculateProfitRate(totalSpent);

        // then
        assertEquals(5.0, profitRate, 0.01); // 5,000 / 1,000 = 5.0
    }
}
