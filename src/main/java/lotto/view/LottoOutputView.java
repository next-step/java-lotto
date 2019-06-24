package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class LottoOutputView {
  public static void print(int amount) {
    String msg = amount + "개를 구매했습니다.";
    System.out.println(msg);
  }

  public static void print(List<Lotto> lottos) {
    lottos.forEach(System.out::println);
  }
}
