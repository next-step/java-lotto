package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.service.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteriesTest {

  @DisplayName("로또정보들을 기준으로 당첨정보와 매칭하여 결과값을 반환하는 테스트.")
  @Test
  void 랭크에맞게매칭값반환() {
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));

    Lotteries lotteries = new Lotteries(lottos);
    WinLottoInfo winLottoInfo = new WinLottoInfo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 31)), 7);

    Map<Rank, Integer> rankIntegerMap = Lotteries.matchLottosForRank(lotteries, winLottoInfo);

    assertThat(rankIntegerMap.get(Rank.THIRD)).isEqualTo(1);
  }

  @DisplayName("로또 콜랙션을 생성하여 리스트로 반환하는 테스트.")
  @Test
  void 일급콜랙션을리스트로반환() {
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));

    Lotteries lotteries = new Lotteries(lottos);

    assertThat(lotteries.toList().size()).isEqualTo(1);
  }
}