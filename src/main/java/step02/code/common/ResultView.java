package step02.code.common;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import step02.code.domain.GradeEnum;
import step02.code.domain.Lotto;

public class ResultView {
  public static void myLotto(List<Lotto> lottos, int passiveLottoSize) {
    System.out.print("수동으로 " + passiveLottoSize + "장, ");
    System.out.println("자동으로 " + (lottos.size() - passiveLottoSize) + "장을 구매했습니다.");
    lottos.forEach(ResultView::lotto);
  }

  public static void lotto(Lotto lotto) {
    String str = lotto.lotto()
                  .stream()
                  .map((number) -> Integer.toString(number.number()))
                  .collect(Collectors.joining(", "));
    System.out.println("[" + str + "]");
  }

  public static void printResult(GradeEnum gradeEnum, int number) {
    if(gradeEnum.equals(GradeEnum.SECOND)) {
      System.out.println(gradeEnum.matched() + "개 일치, 보너스볼 일치" + "(" + gradeEnum.prize() + "원)" + "- " + number + "개");  
      return;
    }
    System.out.println(gradeEnum.matched() + "개 일치 " + "(" + gradeEnum.prize() + "원)" + "- " + number + "개");
  }
  public static void result(Map<GradeEnum, Integer> result) {
    GradeEnum.sorted()
      .stream()
      .forEach(gradeEnum -> printResult(gradeEnum, result.getOrDefault(gradeEnum, 0)));
  }

  public static void rate(float rate) {
    System.out.println("총 수익률은 " + String.format("%.2f", rate) + "입니다.");
  }

}
