package model.lotto.generator;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import model.lotto.LottoNo;

public class LottoNumberGenerator {

  public static final int LOTTO_NUMBER_COUNT = 6;
  private final List<LottoNo> lottoNumber = new LinkedList<>();

  public LottoNumberGenerator() {
    for (int i = 1; i <= 45; i++) {
      lottoNumber.add(LottoNo.of(i));
    }
  }

  public Set<LottoNo> create() {
    Collections.shuffle(lottoNumber);
    return new HashSet<>(lottoNumber.subList(0, LOTTO_NUMBER_COUNT));
  }

}
