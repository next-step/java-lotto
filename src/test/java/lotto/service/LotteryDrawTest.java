package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.TestGenerateLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryDrawTest {

  @DisplayName("입력받은 금액을 천원단위로 받는지 검증 테스트")
  @ParameterizedTest
  @ValueSource(ints = {1,10,100,999,1999})
  void 금액입력값검증(int input) {

    LotteryDraw lotteryDraw = new LotteryDraw(input);

    assertThatThrownBy(lotteryDraw::checkInputValue)
        .isInstanceOf(RuntimeException.class);
  }

  @DisplayName("천원단위 금액을 받아서 구매하는 장수를 카운트 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1","2000,2","10000,10"})
  void 천원단위구매장수확인(int cost, int count) {

    LotteryDraw lotteryDraw = new LotteryDraw(cost);

    assertThat(lotteryDraw.getNumberOfLotto()).isEqualTo(count);
  }

  @DisplayName("금액기준 로또 구매 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1","2000,2","10000,10"})
  void 금액기준로또구매(int cost, int count) {

    LotteryDraw lotteryDraw = new LotteryDraw(cost);
    lotteryDraw.buyLotties();

    assertThat(lotteryDraw.getLottiesInfo().getLotties().size()).isEqualTo(count);
  }

  @DisplayName("당첨번호 입력해서 로또객체 생성 테스트.")
  @Test
  void 당첨번호로또생성() {

    LotteryDraw lotteryDraw = new LotteryDraw();

    Lotto lotto = lotteryDraw.inputWinningNumbers("1,2,3,4,5,6");

    System.out.println("lotto = " + lotto.getWinLotto().size());
    assertThat(lotto.getWinLotto().size()).isEqualTo(6);
  }

  @DisplayName("당첨번호와 로또 비교 비교 테스트.")
  @Test
  void 당첨번호와로또비교() {
    LotteryDraw lotteryDraw = new LotteryDraw(1000);
    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(1,7);
    lotteryDraw.buyLotties(generateLottoNumber);
    Lotties lotties = lotteryDraw.getLottiesInfo();

    Lotto winLotto = lotteryDraw.inputWinningNumbers("1,2,3,4,5,6");

    List<Integer> result = lotteryDraw.matchLottoInfo(lotties, winLotto);
    assertThat(result).containsExactly(6);
  }

}