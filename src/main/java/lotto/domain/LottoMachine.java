package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {

  public static final List<LottoNumber> lotto_numbers;

  private static final int END_NUMBER = 45;

  private static final int START_NUMBER = 1;

  static {
    lotto_numbers = new ArrayList<>();
    for (int i = START_NUMBER; i <= END_NUMBER; i++) {
      lotto_numbers.add(new LottoNumber(i));
    }
  }

  public static Lottos generateAuto(int count) {
    Lottos lottos = new Lottos();
    for (int i = 0; i < count; i++) {
      lottos.add(generateAuto());
    }
    return lottos;
  }

  public static Lotto generateAuto() {
    Collections.shuffle(lotto_numbers);
    Set<LottoNumber> numbers = new HashSet<>();
    for (int i = 0; i < 6; i++) {
      numbers.add(lotto_numbers.get(i));
    }
    return new Lotto(numbers);
  }

  public static Lotto generateManual(List<Integer> manualNumbers) {
    Set<LottoNumber> numbers = new HashSet<>();
    for (Integer number : manualNumbers) {
      numbers.add(new LottoNumber(number));
    }
    return new Lotto(numbers);
  }

}
