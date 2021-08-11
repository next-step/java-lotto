package lotto.domain;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.service.LotteryDraw;
import lotto.service.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
  @DisplayName("당첨로또와 응모로또를 주입후 결과 테스트.")
  @Test
  void 로또결과값반환() {
    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);
    Lotto testLotto = new Lotto(values);

    Lotteries lotteries = new Lotteries();
    List<Lotto> testLottos = lotteries.getLottos();
    testLottos.add(testLotto);

    LotteryDraw lotteryDraw = new LotteryDraw(new LottoMoney(1000));
    WinLottoInfo winLottoInfo = lotteryDraw.createWinLottoInfo("11,12,13,14,15,16", 17);

    LottoResult lottoResult = LottoResult.getResult(winLottoInfo, lotteries);

    Map<Rank, Integer> categoriesRanks = lottoResult.getCategoriesRanks();

    assertThat(categoriesRanks.get(Rank.MISS)).isEqualTo(1);
    assertThat(categoriesRanks.get(Rank.FIFTH)).isEqualTo(0);
    assertThat(categoriesRanks.get(Rank.FOURTH)).isEqualTo(0);
    assertThat(categoriesRanks.get(Rank.THIRD)).isEqualTo(0);
    assertThat(categoriesRanks.get(Rank.FIFTH)).isEqualTo(0);
  }

  @DisplayName("로또결과를 다루는 객체의 불변화 테스트.")
  @Test
  void 로또결과객체불변여부() {
    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);
    Lotto testLotto = new Lotto(values);

    Lotteries lotteries = new Lotteries();
    List<Lotto> testLottos = lotteries.getLottos();
    testLottos.add(testLotto);

    LotteryDraw lotteryDraw = new LotteryDraw(new LottoMoney(1000));
    WinLottoInfo winLottoInfo = lotteryDraw.createWinLottoInfo("4,5,6,11,12,13", 21);

    LottoResult result = LottoResult.getResult(winLottoInfo, lotteries);

    Map<Rank, Integer> categoriesRanks = result.getCategoriesRanks();

    assertThatThrownBy(
        ()->categoriesRanks.put(Rank.MISS,1)
    ).isInstanceOf(UnsupportedOperationException.class);
  }
}