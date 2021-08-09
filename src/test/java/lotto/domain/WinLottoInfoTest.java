package lotto.domain;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import lotto.service.LotteryDraw;
import lotto.service.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoInfoTest {

  @DisplayName("당첨로또에 관련된 로또번호와 보너스번호 생성.")
  @Test
  void 당첨로또정보생성() {
    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);

    Lotto lotto = new Lotto(values);
    int bonus = 7;
    WinLottoInfo winLottoInfo = new WinLottoInfo(lotto,bonus);

    assertThat(winLottoInfo.getBonusLottoNumber()).isEqualTo(new LottoNumber(bonus));
    assertThat(winLottoInfo.getWinLotto()).isEqualTo(new Lotto(values));
    assertThat(winLottoInfo.getLottoNumbers().size()).isEqualTo(6);
  }

  @DisplayName("당첨로또번호와 보너스번호간에 번호 중복시 검증 테스트.")
  @Test
  void 당첨로또번호와보너스번호간의중복검사() {
    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);

    Lotto lotto = new Lotto(values);
    int bonus = 1;

    assertThatThrownBy(
        () -> new WinLottoInfo(lotto,bonus)
    )
        .isInstanceOf(IllegalArgumentException.class);
  }


  @DisplayName("로또값을 비교해서 Rank 각 등급에 맞는 match값을 기준으로 자료구조에 적재되는지 테스트.")
  @Test
  void 자료구조적재테스트() {

    Lotteries lotteries = new Lotteries();
    lotteries.getLottos().add(createTestLottoOneToSix());

    WinLottoInfo winLottoInfo = new WinLottoInfo(new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 6)), 7);

    LottoResult lottoResult = winLottoInfo.getInputMatchTotalInfo(lotteries);

    assertThat(lottoResult.getCategoriesRank().get(Rank.FIRST).size()).isEqualTo(1);
  }

  @DisplayName("당첨 로또와 구매로또의 번호 비교 테스트.")
  @Test
  void 로또번호비교() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    WinLottoInfo winLottoInfo = new WinLottoInfo(new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 31)), 7);

    Method checkContainValues = winLottoInfo.getClass()
        .getDeclaredMethod("checkContainValues", Lotto.class, int.class, LottoNumber.class);
    checkContainValues.setAccessible(true);

    assertThat(
        checkContainValues.invoke(winLottoInfo,
            new Lotto(createTestWinLotto(21, 22, 23, 11, 12, 13)),
            0,
            new LottoNumber(21)))
        .isEqualTo(1);
  }


  @DisplayName("Rank 각 등급에 맞는 match값을 리턴하는지 테스트.")
  @Test
  void 로또등급생성자별비교()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    WinLottoInfo winLottoInfo = new WinLottoInfo(new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 31)), 7);
    Method getMatchCountForRank = winLottoInfo.getClass()
        .getDeclaredMethod("getMatchCountForRank", Lotto.class);
    getMatchCountForRank.setAccessible(true);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(createTestWinLotto(21, 22, 23, 11, 12, 13)))).isEqualTo(Rank.MISS);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 11, 12, 13)))).isEqualTo(Rank.FIFTH);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 4, 12, 13)))).isEqualTo(Rank.FOURTH);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 13)))).isEqualTo(Rank.THIRD);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 7)))).isEqualTo(Rank.SECOND);

    assertThat(getMatchCountForRank.invoke(winLottoInfo,
        new Lotto(createTestWinLotto(1, 2, 3, 4, 5, 31)))).isEqualTo(Rank.FIRST);
  }


  @DisplayName("당첨번호와 로또 비교하여 해당 등수에 로또객체를 적재하는 테스트.")
  @Test
  void 당첨번호와로또비교후등수별정리() {

    List<Integer> values = new ArrayList<>();
    range(1, 7).forEach(values::add);
    Lotto testLotto = new Lotto(values);

    Lotteries lotteries = new Lotteries();
    List<Lotto> testLottos = lotteries.getLottos();
    testLottos.add(testLotto);

    LotteryDraw lotteryDraw = new LotteryDraw(new LottoMoney(1000));

    WinLottoInfo winLottoInfo = lotteryDraw.createWinLottoInfo("4,5,6,11,12,13", 21);
    LottoResult lottoResult = winLottoInfo.matchLottoInfo(lotteries);

    assertThat(lottoResult.getCategoriesRank().get(Rank.FIFTH).size()).isEqualTo(1);
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