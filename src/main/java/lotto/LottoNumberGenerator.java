package lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LottoNumberGenerator {

  private final List<Integer> lottoNumber = new LinkedList<>();

  public void init() {
    for (int i = 1; i <= 45; i++) {
      lottoNumber.add(i);
    }
  }

  public Lotto create() {
    Collections.shuffle(lottoNumber);
    return new Lotto(lottoNumber.subList(0, 6));
  }

}
