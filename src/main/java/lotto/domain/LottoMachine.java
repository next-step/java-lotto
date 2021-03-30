package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {

  public Lottos buyAuto(int count) {
    Lottos lottos = new Lottos();
    for (int i = 0; i < count; i++) {
      lottos.add(generateAuto());
    }
    return lottos;
  }

  public Lotto generateAuto() {
    Set<LottoNumber> numbers = new HashSet<>();
    while (numbers.size() != 6) {
      numbers.add(LottoNumber.generateAuto());
    }
    return new Lotto(numbers);
  }

  public Lotto generateManual(List<Integer> manualNumbers) {
    Set<LottoNumber> numbers = new HashSet<>();
    for (Integer number : manualNumbers) {
      numbers.add(LottoNumber.generateManual(number));
    }
    return new Lotto(numbers);
  }

}
