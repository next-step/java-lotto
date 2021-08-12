package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.service.LotteryDraw;
import lotto.service.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

  @DisplayName("로또결과 등급별 기본값 할당 테스트.")
  @Test
  void 로또결과등급별기본값생성() {
    Map<Rank, Integer> rankByMap = LottoResult.createRankByMap();

    assertThat(rankByMap.get(Rank.MISS)).isEqualTo(0);
    assertThat(rankByMap.get(Rank.FIFTH)).isEqualTo(0);
    assertThat(rankByMap.get(Rank.FOURTH)).isEqualTo(0);
    assertThat(rankByMap.get(Rank.THIRD)).isEqualTo(0);
    assertThat(rankByMap.get(Rank.FIFTH)).isEqualTo(0);
  }

  @DisplayName("당첨결과 총상금액을 반환.")
  @Test
  void 당첨된총상금액반환() {

    List<Lotto> testLottos = new ArrayList<>(
        Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
    Lotteries lotteries = new Lotteries(testLottos);

    LottoResult lottoResult = LottoResult.getResult(LotteryDraw.createWinLottoInfo("4,5,6,11,12,13", 21), lotteries);

    assertThat(lottoResult.allRankResultSum()).isEqualTo(5000);
  }
}