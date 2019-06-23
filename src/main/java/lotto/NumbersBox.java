package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersBox {

  public static final int BOUNDARY_LOTTO_NUMBER = 45;
  public static final int SELECT_LOTTO_NUMBER_COUNT = 6;

  private List<LottoNumber> numbersBox = new ArrayList<>();

  public NumbersBox() {
    initBox();
  }

  public LottoNumbers getLottoNumbers() {
    return new LottoNumbers(
        numbersBox.stream()
            .limit(SELECT_LOTTO_NUMBER_COUNT)
            .collect(Collectors.toList()));
  }

  private void initBox() {
    fillLottoBox();
    shakeLottoBox();

  }

  private void fillLottoBox() {
    for (int i = 1; i <= BOUNDARY_LOTTO_NUMBER; i++) {
      numbersBox.add(new LottoNumber(i));
    }
  }

  private void shakeLottoBox() {
    Collections.shuffle(numbersBox);
  }

}
