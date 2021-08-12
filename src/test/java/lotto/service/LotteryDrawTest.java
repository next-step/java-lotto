package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.WinLottoInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryDrawTest {

  @DisplayName("번호주입을하면 로또가 생성되는지 확인.")
  @Test
  void 번호를주입시로또생성() {
    Lotto lotto = LotteryDraw.inputWinningNumbers("1,2,3,4,5,6");
    Lotto lotto2 = LotteryDraw.inputWinningNumbers("1,2,3,4,5,6");

    assertThat(lotto).isEqualTo(lotto2);
  }

  @DisplayName("당첨번호 입력해서 로또객체 생성 테스트.")
  @Test
  void 당첨번호로또생성() {
    WinLottoInfo winLottoInfo = LotteryDraw.createWinLottoInfo("1,2,3,4,5,6", 7);
    WinLottoInfo winLottoInfo2 = LotteryDraw.createWinLottoInfo("1,2,3,4,5,6", 7);
    assertThat(winLottoInfo).isEqualTo(winLottoInfo2);
  }

  @DisplayName("수익률 계산 테스트.")
  @Test
  void 당첨정보기준수익률계산() {
    List<Lotto> testLottos = new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
    Lotteries lotteries = new Lotteries(testLottos);

    LottoResult lottoResult = LottoResult.getResult(LotteryDraw.createWinLottoInfo("4,5,6,11,12,13", 21), lotteries);

    assertThat(LotteryDraw.gradingScore(lottoResult, new LottoMoney(1000))).isEqualTo(5);
  }

}