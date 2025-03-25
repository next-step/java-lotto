package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResultChecker;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCheckerTest {
    @Test
    public void 당첨번호와_로또정보를_기반으로_등수정보를_반환한다() {
        LottoResultChecker checker = new LottoResultChecker(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> firstNumbers = List.of(1, 2, 3, 4, 5, 6); // 6개 일치
        Lotto firstRankLotto = new Lotto(firstNumbers);
        Rank first = checker.checkLottoResult(firstRankLotto);

        List<Integer> thirdNumbers = List.of(1, 2, 3, 4, 10, 20);   // 4개 일치
        Lotto thirdRankLotto = new Lotto(thirdNumbers);
        Rank third = checker.checkLottoResult(thirdRankLotto);

        List<Integer> noPrizeNumbers = List.of(1, 2, 11, 23, 33, 38);   // 2개 이하 일치
        Lotto noPrizeRankLotto = new Lotto(noPrizeNumbers);
        Rank noPrize = checker.checkLottoResult(noPrizeRankLotto);

        assertThat(first).isEqualTo(Rank.FIRST);
        assertThat(third).isEqualTo(Rank.THIRD);
        assertThat(noPrize).isEqualTo(Rank.NO_PRIZE);
    }

}
