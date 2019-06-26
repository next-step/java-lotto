package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersBox {

  public static final int BOUNDARY_LOTTO_NUMBER = 45;
  public static final int SELECT_LOTTO_NUMBER_COUNT = 6;

  private static List<LottoNumber> numbersBox = new ArrayList<>();

  public static LottoNumbers getLottoNumbers() {
    initBox();
    return new LottoNumbers(
        numbersBox.stream()
            .limit(SELECT_LOTTO_NUMBER_COUNT)
            .collect(Collectors.toList()));
  }

  private static void initBox() {
    fillLottoBox();
    shakeLottoBox();
  }

  private static void fillLottoBox() {
    if(numbersBox.size() > 0) {
      return;
    }
    for (int i = 1; i <= BOUNDARY_LOTTO_NUMBER; i++) {
      numbersBox.add(new LottoNumber(i));
    }
  }

  private static void shakeLottoBox() {
    Collections.shuffle(numbersBox);
  }

}
