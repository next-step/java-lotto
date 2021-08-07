package lotto.domain;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.service.LotteryDraw;
import lotto.service.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteriesTest {

  @DisplayName("입력 갯수만큼 로또 생성 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  void 입력한만큼로또생성(int count)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Lotteries lotteries = new Lotteries();

    Method createLotteries = lotteries.getClass()
        .getDeclaredMethod("createLotteries", int.class);
    createLotteries.setAccessible(true);

    createLotteries.invoke(lotteries, count);

    assertThat(lotteries.getLottos().size()).isEqualTo(count);
  }

  @DisplayName("당첨 로또와 구매로또의 번호 비교 테스트.")
  @Test
  void 로또번호비교() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Lotteries lotteries = new Lotteries();

    Method checkContainValues = lotteries.getClass()
        .getDeclaredMethod("checkContainValues", Lotto.class, int.class, LottoNumber.class);
    checkContainValues.setAccessible(true);

    assertThat(
        checkContainValues.invoke(lotteries,
            Lotto.getWinningLotto(createTestWinLotto(21, 22, 23, 11, 12, 13)),
            0,
            new LottoNumber(21)))
        .isEqualTo(1);
  }

  @DisplayName("Rank 각 등급에 맞는 match값을 리턴하는지 테스트.")
  @Test
  void Rank생성자별비교()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Lotteries lotteries = new Lotteries();
    Method getMatchLotteries = lotteries.getClass()
        .getDeclaredMethod("getMatchLotteries", Lotto.class, Lotto.class);
    getMatchLotteries.setAccessible(true);

    assertThat(getMatchLotteries.invoke(lotteries, createTestLottoOneToSix(),
        Lotto.getWinningLotto(createTestWinLotto(21, 22, 23, 11, 12, 13)))).isEqualTo(Rank.MISS);

    assertThat(getMatchLotteries.invoke(lotteries, createTestLottoOneToSix(),
        Lotto.getWinningLotto(createTestWinLotto(1, 2, 3, 11, 12, 13)))).isEqualTo(Rank.FIFTH);

    assertThat(getMatchLotteries.invoke(lotteries, createTestLottoOneToSix(),
        Lotto.getWinningLotto(createTestWinLotto(1, 2, 3, 4, 12, 13)))).isEqualTo(Rank.FOURTH);

    assertThat(getMatchLotteries.invoke(lotteries, createTestLottoOneToSix(),
        Lotto.getWinningLotto(createTestWinLotto(1, 2, 3, 4, 5, 13)))).isEqualTo(Rank.THIRD);

    assertThat(getMatchLotteries.invoke(lotteries, createTestLottoOneToSix(),
        Lotto.getWinningLotto(createTestWinLotto(1, 2, 3, 4, 5, 6)))).isEqualTo(Rank.FIRST);
  }

  @DisplayName("로또값을 비교해서 Rank 각 등급에 맞는 match값을 기준으로 자료구조에 적재되는지 테스트.")
  @Test
  void 자료구조적재테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    LotteryDraw lotteryDraw = new LotteryDraw();

    Method createRatingInfo = lotteryDraw.getClass()
        .getDeclaredMethod("createRatingInfo");
    createRatingInfo.setAccessible(true);

    Map<Rank, List<Lotto>> categoriesRank = (Map<Rank, List<Lotto>>) createRatingInfo.invoke(
        lotteryDraw);

    Lotteries lotteries = new Lotteries();

    lotteries.getLottos().add(createTestLottoOneToSix());

    Map<Rank, List<Lotto>> result = lotteries.getInputMatchTotalInfo(categoriesRank,
        Lotto.getWinningLotto(createTestWinLotto(1, 2, 3, 4, 5, 6)));

    assertThat(result.get(Rank.FIRST).size()).isEqualTo(1);
  }

  private List<Integer> createTestWinLotto(final int number1, final int number2, final int number3,
      final int number4, final int number5, final int number6) {
    List<Integer> win = new ArrayList<>();
    win.add(number1);
    win.add(number2);
    win.add(number3);
    win.add(number4);
    win.add(number5);
    win.add(number6);

    return win;
  }

  private Lotto createTestLottoOneToSix() {
    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);
    return new Lotto(values);
  }
}