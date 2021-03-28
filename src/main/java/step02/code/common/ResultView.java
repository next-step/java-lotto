package step02.code.common;

import java.util.List;
import java.util.stream.Collectors;

import step02.code.domain.Lotto;

public class ResultView {
  public static void myLotto(List<Lotto> lottos) {
    System.out.println(lottos.size() + "를 구매했습니다.");
    lottos.forEach(ResultView::lotto);
  }

  public static void lotto(Lotto lotto) {
    String str = lotto.lotto()
                  .stream()
                  .map((number) -> Integer.toString(number.number()))
                  .collect(Collectors.joining(", "));
    System.out.println("[" + str + "]");
  }

  public static void result(int matched, int prize, int number) {
    System.out.println(matched + "개 일치 " + "(" + prize + ")" + "- " + number);
  }

  public static void rate(float rate) {
    System.out.println("총 수익률은 " + String.format("%.2f", rate) + "입니다.");
  }

}
