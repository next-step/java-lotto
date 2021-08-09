package lotto.domain;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import lotto.service.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteriesTest {

  @DisplayName("입력 갯수만큼 로또 생성 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  void 입력한만큼로또생성(int count) {

    Lotteries lotteries = new Lotteries(count);

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
            new Lotto(createTestWinLotto(21, 22, 23, 11, 12, 13)),
            0,
            new LottoNumber(21)))
        .isEqualTo(1);
  }

  @DisplayName("Rank 각 등급에 맞는 match값을 리턴하는지 테스트.")
  @Test
  void 로또등급생성자별비교()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Lotteries lotteries = new Lotteries();
    Method getMatchLotteries = lotteries.getClass()
        .getDeclaredMethod("getMatchCountForRank", WinLottoInfo.class, Lotto.class);
    getMatchLotteries.setAccessible(true);

    WinLottoInfo winLottoInfo = new WinLottoInfo(new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 31)), 7);

    assertThat(getMatchLotteries.invoke(lotteries, winLottoInfo,
        new Lotto(createTestWinLotto(21, 22, 23, 11, 12, 13)))).isEqualTo(Rank.MISS);

    assertThat(getMatchLotteries.invoke(lotteries, winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 11, 12, 13)))).isEqualTo(Rank.FIFTH);

    assertThat(getMatchLotteries.invoke(lotteries, winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 4, 12, 13)))).isEqualTo(Rank.FOURTH);

    assertThat(getMatchLotteries.invoke(lotteries, winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 13)))).isEqualTo(Rank.THIRD);

    assertThat(getMatchLotteries.invoke(lotteries, winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 7)))).isEqualTo(Rank.SECOND);

    assertThat(getMatchLotteries.invoke(lotteries, winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 31)))).isEqualTo(Rank.FIRST);
  }

  @DisplayName("로또값을 비교해서 Rank 각 등급에 맞는 match값을 기준으로 자료구조에 적재되는지 테스트.")
  @Test
  void 자료구조적재테스트() {

    Lotteries lotteries = new Lotteries();
    lotteries.getLottos().add(createTestLottoOneToSix());

    WinLottoInfo winLottoInfo = new WinLottoInfo(new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 6)), 7);

    LottoResult lottoResult = lotteries.getInputMatchTotalInfo(winLottoInfo);

    assertThat(lottoResult.getCategoriesRank().get(Rank.FIRST).size()).isEqualTo(1);
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