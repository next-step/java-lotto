package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.TestGenerateLottoNumber;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryDrawTest {

  @DisplayName("입력받은 금액을 천원단위로 받는지 검증 테스트")
  @ParameterizedTest
  @ValueSource(ints = {1, 10, 100, 999, 1999})
  void 금액입력값검증(int input){

    LotteryDraw lotteryDraw = new LotteryDraw(input);

    try {
      Method createLotteyrDraw = lotteryDraw.getClass()
          .getDeclaredMethod("checkInputValue");
      createLotteyrDraw.setAccessible(true);

      assertThatThrownBy(
          (ThrowingCallable) createLotteyrDraw.invoke(lotteryDraw)).isInstanceOf(RuntimeException.class);

    } catch (NoSuchMethodException e) {
    } catch (IllegalAccessException e) {
    } catch (InvocationTargetException e) {
    }
  }

  @DisplayName("천원단위 금액을 받아서 구매하는 장수를 카운트 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1", "2000,2", "10000,10"})
  void 천원단위구매장수확인(int cost, int count) {

    LotteryDraw lotteryDraw = new LotteryDraw(cost);

    try {

      Method getNumberOfLotto = lotteryDraw.getClass()
          .getDeclaredMethod("getNumberOfLotto");
      getNumberOfLotto.setAccessible(true);

      assertThat(getNumberOfLotto.invoke(lotteryDraw)).isEqualTo(count);

    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  @DisplayName("금액기준 로또 구매 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1", "2000,2", "10000,10"})
  void 금액기준로또구매(int cost, int count) {

    LotteryDraw lotteryDraw = new LotteryDraw(cost);
    List<Integer> testLotto = createTestLotto(11, 2, 33, 44, 5, 6);
    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(0, 6, testLotto);
    lotteryDraw.buyLotteries(generateLottoNumber);

    assertThat(lotteryDraw.getLotteriesInfo().getLotteries().size()).isEqualTo(count);
  }

  @DisplayName("당첨번호 입력해서 로또객체 생성 테스트.")
  @Test
  void 당첨번호로또생성() {

    LotteryDraw lotteryDraw = new LotteryDraw();
    Lotto lotto = lotteryDraw.inputWinningNumbers("1,2,3,4,5,6");

    assertThat(lotto.getLotto().size()).isEqualTo(6);
  }

  @DisplayName("당첨번호와 로또 비교하여 해당 등수에 로또객체를 적재하는 테스트.")
  @Test
  void 당첨번호와로또비교후등수별정리() {
    LotteryDraw lotteryDraw = new LotteryDraw(1000);
    List<Integer> testLotto = createTestLotto(11, 2, 33, 44, 5, 6);

    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(0, 6, testLotto);
    lotteryDraw.buyLotteries(generateLottoNumber);

    Lotto winLotto = lotteryDraw.inputWinningNumbers("1,2,3,4,5,6");

    Map<Integer, List<Lotto>> result = lotteryDraw.matchLottoInfo(lotteryDraw.getLotteriesInfo(),
        winLotto);

    assertThat(result.get(3).size()).isEqualTo(1);
  }

  private List<Integer> createTestLotto(int num1, int num2, int num3, int num4, int num5,
      int num6) {
    List<Integer> testLotto = new ArrayList<>();
    testLotto.add(num1);
    testLotto.add(num2);
    testLotto.add(num3);
    testLotto.add(num4);
    testLotto.add(num5);
    testLotto.add(num6);

    return testLotto;
  }

}