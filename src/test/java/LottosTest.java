import Lotto.constants.LottoPrize;
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
        int mockQuantity = 6;
        Lottos lottoList = new Lottos(mockQuantity);
        Set<LottoNumber> winningNumbers = Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        lottoList.addLotto(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9))));
        lottoList.addLotto(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(8), new LottoNumber(9))));

        Map<LottoPrize, Integer> stats = new ResultStats(lottoList.getLottos(), winningNumbers).getStats();

        assertEquals(1, stats.getOrDefault(LottoPrize.THREE_MATCH, 0), "3개 일치하는 로또 개수는 1개여야 합니다.");
        assertEquals(1, stats.getOrDefault(LottoPrize.FOUR_MATCH, 0), "4개 일치하는 로또 개수는 1개여야 합니다.");
        assertEquals(0, stats.getOrDefault(LottoPrize.FIVE_MATCH, 0), "5개 이상 일치하는 로또가 없어야 합니다.");
        assertEquals(0, stats.getOrDefault(LottoPrize.SIX_MATCH, 0), "6개 일치하는 로또가 없어야 합니다.");
    }
}
