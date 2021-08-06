package lotto.service;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
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
    assertThatThrownBy(()->
        lotteryDraw.buyLotteries()
    ).isInstanceOf(RuntimeException.class);
  }

  @DisplayName("천원단위 금액을 받아서 구매하는 장수를 카운트 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1", "2000,2", "10000,10"})
  void 천원단위구매장수확인(int cost, int count)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    LotteryDraw lotteryDraw = new LotteryDraw(cost);
    Method getNumberOfLotto = lotteryDraw.getClass()
        .getDeclaredMethod("getNumberOfLotto");
    getNumberOfLotto.setAccessible(true);

    assertThat(getNumberOfLotto.invoke(lotteryDraw)).isEqualTo(count);

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
    lotteryDraw.buyLotteries();

    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);
    Lotto testLotto = new Lotto(values);

    Lotteries lotteriesInfo = lotteryDraw.getLotteriesInfo();
    List<Lotto> testLottos = lotteriesInfo.getLottos();
    testLottos.add(testLotto);

    Lotto winLotto = lotteryDraw.inputWinningNumbers("11,12,13,4,5,6");

    Map<Integer, List<Lotto>> result = lotteryDraw.matchLottoInfo(lotteriesInfo,
        winLotto);

    assertThat(result.get(3).size()).isEqualTo(1);
  }
}