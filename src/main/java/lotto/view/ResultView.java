package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class ResultView {

  private static final String DAMAGE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
  private static final String DELIMITER = ", ";

  public static void printLottos(Lottos lottos) {
    for (Lotto ticket : lottos.getTickets()) {
      printLottoNumber(ticket);
    }
  }

  private static void printLottoNumber(Lotto lotto) {
    System.out.println(getLottoNumberString(lotto));
  }

  private static String getLottoNumberString(Lotto lotto) {
    List<Integer> list = new ArrayList<>();
    for (LottoNumber lottoNumber : lotto.getTicket()) {
      list.add((lottoNumber.getNumber()));
    }
    Collections.sort(list);
    String result = joinToString(list, DELIMITER);
    return "[" + result + "]";
  }

  private static String joinToString(List<Integer> list, String delimiter) {
    List<String> stringList = new ArrayList<>();
    for (Integer number : list) {
      String numberString = String.valueOf(number);
      stringList.add(numberString);
    }
    return String.join(delimiter, stringList);
  }

  public static void printResult(Lottos lottos) {
    System.out.println("당첨통계");
    System.out.println("-----------");

    printLottoResult(lottos, LottoResult.FIFTH);
    printLottoResult(lottos, LottoResult.FOURTH);
    printLottoResult(lottos, LottoResult.THIRD);
    printLottoResult(lottos, LottoResult.SECOND);
    printLottoResult(lottos, LottoResult.FIRST);
  }

  private static void printLottoResult(Lottos lottos, LottoResult result) {
    int count = lottos.getCount(result);
    String message
        = String.format("%s개 일 (%s원) - %s개", result.getContainsCount(), result.getRewardPrice(), count);
    System.out.println(message);
  }

  public static void printIncomePercent(double incomePercent) {
    String message = String.format("총 수익률은 %.2f 입니다.", incomePercent);
    System.out.print(message);
    printDamage(incomePercent);
  }

  private static void printDamage(double incomePercent) {
    if (incomePercent < 1) {
      System.out.println(DAMAGE_MESSAGE);
    }
  }
}
