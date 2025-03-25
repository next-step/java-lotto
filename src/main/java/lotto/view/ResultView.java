package lotto.view;

import lotto.Lotto;
import lotto.LottoNumber;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {
  public static void printLottos(List<Lotto> lottos) {
    for (Lotto lotto : lottos) {
      System.out.println("[" + lotto.getNumbers().stream()
              .map(LottoNumber::getValue)
              .map(String::valueOf)
              .collect(joining(", ")) + "]");
    }
  }
}
