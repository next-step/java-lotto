package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoListTest {

    @Test
    @DisplayName("당첨 통계 확인")
    public void makeMatchingCount() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of(Arrays.asList(1,2,3,4,5,6)));
        lottos.add(Lotto.of(Arrays.asList(34,25,35,32,43,12)));

        LottoList lottolist = new LottoList(lottos);
        Lotto lastWeekWinningLotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));

        LottoStatistics actual = lottolist.makeMatchingCount(lastWeekWinningLotto);

        Map<LottoRank,Integer> expected = new HashMap<>();
        expected.put(LottoRank.FIRST,1);
        expected.put(LottoRank.SECOND,0);
        expected.put(LottoRank.THIRD,0);
        expected.put(LottoRank.FOURTH,0);
        expected.put(LottoRank.ZERO,0);

        assertEquals(actual.getlottoStaticResultMap(),expected);
    }


}
