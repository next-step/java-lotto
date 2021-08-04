package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
  @ValueSource(ints = {1, 10, 100, 999, 1999})
  void 금액입력값검증(int input) {

    LotteryDraw lotteryDraw = new LotteryDraw(input);

    assertThatThrownBy(lotteryDraw::checkInputValue)
        .isInstanceOf(RuntimeException.class);
  }

  @DisplayName("천원단위 금액을 받아서 구매하는 장수를 카운트 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1", "2000,2", "10000,10"})
  void 천원단위구매장수확인(int cost, int count) {

    LotteryDraw lotteryDraw = new LotteryDraw(cost);

    assertThat(lotteryDraw.getNumberOfLotto()).isEqualTo(count);
  }

  @DisplayName("금액기준 로또 구매 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1", "2000,2", "10000,10"})
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

    assertThat(lotto.getWinLotto().size()).isEqualTo(6);
  }

  @DisplayName("당첨번호와 로또 비교하여 해당 등수에 로또객체를 적재하는 테스트.")
  @Test
  void 당첨번호와로또비교후등수별정리() {
    LotteryDraw lotteryDraw = new LotteryDraw(1000);
    List<Integer> testLotto = createTestLotto(11,2,33,44,5,6);

    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(0, 6, testLotto);
    lotteryDraw.buyLotties(generateLottoNumber);

    Lotto winLotto = lotteryDraw.inputWinningNumbers("1,2,3,4,5,6");

    Map<Integer, List<Lotto>> result = lotteryDraw.matchLottoInfo(lotteryDraw.getLottiesInfo(),
        winLotto);

    assertThat(result.get(3).size()).isEqualTo(1);
  }

  private List<Integer> createTestLotto(int num1, int num2, int num3, int num4, int num5, int num6) {
    List<Integer> testLotto = new ArrayList<>();
    testLotto.add(num1);
    testLotto.add(num2);
    testLotto.add(num3);
    testLotto.add(num4);
    testLotto.add(num5);
    testLotto.add(num6);

    return testLotto;
  }

  @DisplayName("수익률 계산 테스트.")
  @Test
  void 로또수익률계산() {
    List<Integer> testLotto = createTestLotto(11,2,33,44,5,6);
    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(0, 6, testLotto);
    Lotto lotto = new Lotto(generateLottoNumber);

    Map<Integer, List<Lotto>> result = new LinkedHashMap<>();
    result.put(3, Collections.singletonList(lotto));

    LotteryDraw lotteryDraw = new LotteryDraw(14000);

    assertThat(lotteryDraw.gradingScore(result)).isEqualTo("0.35");
  }

}