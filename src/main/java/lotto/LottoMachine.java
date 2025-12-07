package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

  public static Lotto randomLotto() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = Lotto.MIN_NUMBER; i <= Lotto.MAX_NUMBER; i++) {
      numbers.add(i);
    }
    Collections.shuffle(numbers);

    List<Integer> lottoNumbers = numbers.subList(0, 6);
    return Lotto.fromIntegers(lottoNumbers);
  }
}
