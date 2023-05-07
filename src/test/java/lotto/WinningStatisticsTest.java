package lotto;

import lotto.utility.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LotteryTickets;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class WinningStatisticsTest {
  @ParameterizedTest
  @CsvSource(value = {"3000, 3", "4500, 4", "7000, 7"})
  @DisplayName("로또 당첨 map 타입으로 반환")
  public void lottoResultTest_Key(String budget, int expect) {
    LotteryTickets lotteryTickets = new LotteryTickets();

    lotteryTickets.purchase(InputConverter.convertBudgetToInt(budget));
    List<Lotto> lottoBundle = lotteryTickets.getLottoBundle();

    String strList = "1, 2, 3, 4, 5, 6";

    List<Integer> targetNumber = InputConverter.convertNumberToList(strList);
    int bonusNumber = InputConverter.convertBonusNumber(targetNumber, "17");

    WinningStatistics winningStatistics = new WinningStatistics(targetNumber, bonusNumber);

    Map<Integer, Integer> result = winningStatistics.lottoResult(lottoBundle);
    System.out.println(result);

    Iterator<Integer> keys = result.keySet().iterator();
    int sumValue = 0;

//    while (keys.hasNext()) {
//      int key = keys.next();
//      int value = result.get(key);
//
//      assertThat(value).isLessThanOrEqualTo(expect);
//
//      sumValue += value;
//    }
//
//    assertEquals(sumValue, expect);
  }

  @Test
  @DisplayName("로또 당첨 3개 매치 1개, 6개 매치 1개인 map 반환")
  public void lottoResultTest_Value() {
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 43, 44, 45)));
    List<Lotto> lottoBundle = new ArrayList<>();

    String strList = "1, 2, 3, 4, 5, 6";

    lottoBundle.add(lotto);
    lottoBundle.add(lotto2);

    List<Integer> targetNumber = InputConverter.convertNumberToList(strList);
    int bonusNumber = InputConverter.convertBonusNumber(targetNumber, "17");

    WinningStatistics winningStatistics = new WinningStatistics(targetNumber, bonusNumber);

    Map<Integer, Integer> map = winningStatistics.lottoResult(lottoBundle);

    assertEquals(map.get(3), 1);
    assertEquals(map.get(6), 1);
  }

  @Test
  @DisplayName("로또 당첨 3개 매치 1개, 6개 매치 1개의 상금인 2000005000 반환")
  public void sumTotalWinningPriceTest() {
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 43, 44, 45)));
    Lotto lotto3 = new Lotto(new ArrayList<>(Arrays.asList(40, 41, 42, 43, 44, 45)));
    List<Lotto> lottoBundle = new ArrayList<>();

    String strList = "1, 2, 3, 4, 5, 6";

    lottoBundle.add(lotto);
    lottoBundle.add(lotto2);
    lottoBundle.add(lotto3);

    List<Integer> targetNumber = InputConverter.convertNumberToList(strList);
    int bonusNumber = InputConverter.convertBonusNumber(targetNumber, "17");

    WinningStatistics winningStatistics = new WinningStatistics(targetNumber, bonusNumber);

    Map<Integer, Integer> map = winningStatistics.lottoResult(lottoBundle);
    int result = winningStatistics.showTotalWinningPrice();

    assertEquals(result, 2000005000);
  }

  @Test
  @DisplayName("투자금: 5000원, 로또 상금: 5000원 -> 수익률 1.0 반환")
  public void calcRoiTest() {
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 43, 44, 45)));
    Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(41, 42, 43, 43, 44, 45)));
    Lotto lotto3 = new Lotto(new ArrayList<>(Arrays.asList(41, 42, 43, 43, 44, 45)));
    Lotto lotto4 = new Lotto(new ArrayList<>(Arrays.asList(41, 42, 43, 43, 44, 45)));
    Lotto lotto5 = new Lotto(new ArrayList<>(Arrays.asList(41, 42, 43, 43, 44, 45)));
    List<Lotto> lottoBundle = new ArrayList<>();

    String strList = "1, 2, 3, 4, 5, 6";

    lottoBundle.add(lotto);
    lottoBundle.add(lotto2);
    lottoBundle.add(lotto3);
    lottoBundle.add(lotto4);
    lottoBundle.add(lotto5);

    List<Integer> targetNumber = InputConverter.convertNumberToList(strList);

    int bonusNumber = InputConverter.convertBonusNumber(targetNumber, "17");

    WinningStatistics winningStatistics = new WinningStatistics(targetNumber, bonusNumber);
    System.out.println(winningStatistics.showTotalWinningPrice());

    Map<Integer, Integer> map = winningStatistics.lottoResult(lottoBundle);
    double result = winningStatistics.calcRoi(winningStatistics.showTotalWinningPrice(), 5000);

    assertEquals(result, 1.0);
  }


}
