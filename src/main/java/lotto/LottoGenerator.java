package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

  public static Lottos generateLottos(int count) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      lottos.add(generateLotto());
    }
    return new Lottos(lottos);
  }

  private static Lotto generateLotto() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = Lotto.MIN_NUMBER; i <= Lotto.MAX_NUMBER; i++) {
      numbers.add(i);
    }
    Collections.shuffle(numbers);

    List<Integer> lottoNumbers = numbers.subList(0, 6);
    return new Lotto(lottoNumbers);
  }
}
