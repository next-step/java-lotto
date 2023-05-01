package lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LottoNumberGenerator {

  private final List<Integer> lottoNumber = new LinkedList<>();

  public LottoNumberGenerator() {
    for (int i = 1; i <= 45; i++) {
      lottoNumber.add(i);
    }
  }

  public List<Integer> create() {
    Collections.shuffle(lottoNumber);
    return new LinkedList<>(lottoNumber.subList(0, 6));
  }

}
