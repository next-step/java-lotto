package step02.code.common;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
  public static void myLotto(List<List<Integer>> lottos) {
    System.out.println(lottos.size() + "를 구매했습니다.");
    lottos.forEach(ResultView::lotto);
  }

  public static void lotto(List<Integer> lotto) {
    String str = lotto.stream()
                  .map(Object::toString)
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
