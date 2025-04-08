import Lotto.constants.Rank;
import Lotto.domain.Lottos;
import Lotto.domain.LottoNumber;
import Lotto.domain.Lotto;

import Lotto.domain.ResultStats;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosTest {
    @Test
    void calculateStats_ShouldReturnCorrectCounts() {
        int mockQuantity = 6; // 가상의 로또 개수
        Lottos lottoList = new Lottos(mockQuantity);
        Set<LottoNumber> winningNumbers = Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoNumber bonusNumber = new LottoNumber(7); // 보너스 번호

        lottoList.addLotto(new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9))));
        lottoList.addLotto(new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(8), new LottoNumber(9))));

        ResultStats resultStats = new ResultStats(lottoList.getLottos(), winningNumbers, bonusNumber);
        Map<Rank, Integer> stats = resultStats.getStats();

        assertEquals(1, stats.getOrDefault(Rank.FIFTH, 0), "3개 일치하는 로또 개수는 1개여야 합니다.");
        assertEquals(1, stats.getOrDefault(Rank.FOURTH, 0), "4개 일치하는 로또 개수는 1개여야 합니다.");
        assertEquals(0, stats.getOrDefault(Rank.THIRD, 0), "5개 일치하는 로또가 없어야 합니다.");
        assertEquals(0, stats.getOrDefault(Rank.SECOND, 0), "5개 + 보너스 볼 일치하는 로또가 없어야 합니다.");
        assertEquals(0, stats.getOrDefault(Rank.FIRST, 0), "6개 일치하는 로또가 없어야 합니다.");
    }
}
