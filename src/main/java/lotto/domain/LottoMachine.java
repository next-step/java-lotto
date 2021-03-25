package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {

  public static final List<LottoNumber> LOTTO_NUMBERS;

  static {
    LOTTO_NUMBERS = new ArrayList<>();
    for (int i = LottoNumber.START_NUMBER; i <= LottoNumber.END_NUMBER; i++) {
      LOTTO_NUMBERS.add(new LottoNumber(i));
    }
  }

  public Lottos generateAuto(int count) {
    Lottos lottos = new Lottos();
    for (int i = 0; i < count; i++) {
      lottos.add(generateAuto());
    }
    return lottos;
  }

  public Lotto generateAuto() {
    Collections.shuffle(LOTTO_NUMBERS);
    Set<LottoNumber> numbers = new HashSet<>();
    for (int i = 0; i < 6; i++) {
      numbers.add(LOTTO_NUMBERS.get(i));
    }
    return new Lotto(numbers);
  }

  public Lotto generateManual(List<Integer> manualNumbers) {
    Set<LottoNumber> numbers = new HashSet<>();
    for (Integer number : manualNumbers) {
      numbers.add(new LottoNumber(number));
    }
    return new Lotto(numbers);
  }

}
