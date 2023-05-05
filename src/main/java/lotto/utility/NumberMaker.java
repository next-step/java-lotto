package lotto.utility;

import java.util.Collections;
import java.util.List;

public class NumberMaker {

  public List<Integer> makeSixLottoNumber(List<Integer> numberList) {
    return sortNumber(shuffleNumber(numberList).subList(0, 6));
  }

  private List<Integer> shuffleNumber(List<Integer> numberList) {
    Collections.shuffle(numberList);

    return numberList;
  }

  private List<Integer> sortNumber(List<Integer> numberList) {
    Collections.sort(numberList);

    return numberList;
  }
}
