package lotto.factory;

import static lotto.domain.LottoNumbers.pick;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoNumbersSelector;

public class LottoNumbersSelectorFactory {

  public static LottoNumbersSelector oneToSix() {
    return number -> new ArrayList<>(List.of(pick("1"), pick("2"), pick("3"),
        pick("4"), pick("5"), pick("6")));
  }

  public static LottoNumbersSelector oneToFiveAndSeven() {
    return number -> new ArrayList<>(List.of(pick("1"), pick("2"), pick("3"),
        pick("4"), pick("5"), pick("7")));
  }
}
