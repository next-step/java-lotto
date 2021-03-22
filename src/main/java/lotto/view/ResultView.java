package lotto.view;

import java.util.List;
import lotto.domain.LottoNumbers;

public class ResultView {

  public static void showAmountOfLotto(int amount) {
    System.out.println(amount + "개를 구매했습니다.");
  }

  public static void showLottoNumbers(List<LottoNumbers> lottos) {
    lottos.stream().map(lotto -> lotto.toString())
        .forEach(System.out::println);
    System.out.println();
  }
}
