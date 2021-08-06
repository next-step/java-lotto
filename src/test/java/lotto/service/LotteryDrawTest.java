package lotto.service;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryDrawTest {

  @DisplayName("당첨번호 입력해서 로또객체 생성 테스트.")
  @Test
  void 당첨번호로또생성() {
    LottoGameApplication gameApplication = new LottoGameApplication(1000);
    LotteryDraw lotteryDraw = new LotteryDraw(gameApplication);
    Lotto lotto = lotteryDraw.inputWinningNumbers("1,2,3,4,5,6");

    assertThat(lotto.getLotto().size()).isEqualTo(6);
  }

  @DisplayName("당첨번호와 로또 비교하여 해당 등수에 로또객체를 적재하는 테스트.")
  @Test
  void 당첨번호와로또비교후등수별정리() {

    LottoGameApplication gameApplication = new LottoGameApplication(1000);
    gameApplication.buyLotteries();

    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);
    Lotto testLotto = new Lotto(values);

    Lotteries lotteriesInfo = gameApplication.getLotteriesInfo();
    List<Lotto> testLottos = lotteriesInfo.getLottos();
    testLottos.add(testLotto);

    LotteryDraw lotteryDraw = new LotteryDraw(gameApplication);
    Lotto winLotto = lotteryDraw.inputWinningNumbers("11,12,13,4,5,6");

    Map<Integer, List<Lotto>> result = lotteryDraw.matchLottoInfo(winLotto);

    assertThat(result.get(3).size()).isEqualTo(1);
  }
}