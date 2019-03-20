package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Money;
import lotto.domain.Number;

public class ConsoleResultView {

  public static void printIssueLottoNumbers(List<Number> numbers) {

    String numbersString = numbers.stream()
        .map(Number::toString)
        .collect(Collectors.joining(", "));

    System.out.println("[" + numbersString + "]");
  }

  public static void printMatchWinCount(int matchCount, Money winMoney, long winCount) {

    System.out.println(matchCount + "개 일치 (" + winMoney + "원) - " + winCount +"개");
  }

  public static void printYield(String yield) {

    System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", yield);
  }

  public static void printResultTitle() {

    System.out.println("당첨 통계\n---------");
  }
}
