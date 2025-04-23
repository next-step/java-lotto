import Lotto.domain.Rank;
import Lotto.domain.Lottos;
import Lotto.domain.LottoNumber;
import Lotto.domain.Lotto;

import Lotto.domain.ResultStats;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosTest {

    @DisplayName("통계 계산 시 각 등수에 대한 개수를 정확히 반환한다")
    @Test
    void should_return_correct_counts_for_each_rank() {
        Lottos lottoList = new Lottos();

        Set<LottoNumber> winningNumbers = Set.of(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)
        );
        LottoNumber bonusNumber = LottoNumber.of(7);

        lottoList.add(new Lotto(List.of(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9)
        )));
        lottoList.add(new Lotto(List.of(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(5), LottoNumber.of(8), LottoNumber.of(9)
        )));

        Map<Rank, Integer> stats = new EnumMap<>(Rank.class);
        int totalPrize = 0;
        List<Lotto> lottos = lottoList.getLottos();

        for (Lotto lotto : lottos) {
            Rank rank = Rank.fromMatchCountAndBonus(
                    lotto.countMatches(winningNumbers),
                    lotto.contains(bonusNumber)
            );
            stats.put(rank, stats.getOrDefault(rank, 0) + 1);
            totalPrize += rank.getWinningMoney();
        }

        ResultStats resultStats = new ResultStats(stats, totalPrize);

        assertEquals(1, resultStats.getCountByRank(Rank.FIFTH), "3개 숫자가 일치하는 로또는 1개여야 합니다.");
        assertEquals(1, resultStats.getCountByRank(Rank.FOURTH), "4개 숫자가 일치하는 로또는 1개여야 합니다.");
        assertEquals(0, resultStats.getCountByRank(Rank.THIRD), "5개 숫자가 일치하는 로또는 없어야 합니다.");
        assertEquals(0, resultStats.getCountByRank(Rank.SECOND), "5개 숫자와 보너스 번호가 일치하는 로또는 없어야 합니다.");
        assertEquals(0, resultStats.getCountByRank(Rank.FIRST), "6개 숫자가 모두 일치하는 로또는 없어야 합니다.");
    }
}
