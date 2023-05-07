package lotto.domain;

import lotto.dto.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    @DisplayName("주어진 금액만큼 구매 가능한 개수의 Lotto를 생성하여 리스트에 추가한다.")
    void 로또구매() {
        Lottos lottos = new Lottos(10000);
        assertThat(lottos.count()).isEqualTo(10);
    }

    @Test
    @DisplayName("당첨번호와 비교하여 등수별 개수를 알려준다.")
    void 등수별개수() {
        List<Lotto> lottoList = new ArrayList();
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,10))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,9,10))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,8,9,10))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1,2,7,8,9,10))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1,6,7,8,9,10))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(5,6,7,8,9,10))));

        Lottos lottos = new Lottos(lottoList);
        WinningLotto winningLotto = new WinningLotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

        Result result = lottos.getWinningResult(winningLotto);

        HashMap<Rank, Integer> expectedRankCount = new HashMap<Rank, Integer>();
        expectedRankCount.put(Rank.FIRST, 1);
        expectedRankCount.put(Rank.SECOND, 1);
        expectedRankCount.put(Rank.THIRD, 1);
        expectedRankCount.put(Rank.FOURTH, 1);
        assertThat(result.getRankCounts()).isEqualTo(expectedRankCount);
    }
}
