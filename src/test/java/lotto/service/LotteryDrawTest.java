package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryDrawTest {

  @DisplayName("당첨번호 입력해서 로또객체 생성 테스트.")
  @Test
  void 당첨번호로또생성() {

    LotteryDraw lotteryDraw = new LotteryDraw(new LottoMoney(1000));
    Lotto lotto = lotteryDraw.inputWinningNumbers("1,2,3,4,5,6");

    assertThat(lotto.getLotto().size()).isEqualTo(6);
  }

  @DisplayName("당첨로또와 보너스번호를 가진 당첨로또정보객체 생성")
  @Test
  void 당첨로또정보객체생성() {
    LotteryDraw lotteryDraw = new LotteryDraw(new LottoMoney(1000));
    lotteryDraw.createWinLottoInfo("1,2,3,4,5,7",6);
  }

}