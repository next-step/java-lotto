package model;

import java.util.HashMap;
import java.util.Map;

public class LottoNo implements Comparable<LottoNo>{

  private final Integer lottoNumber;
  private static final Map<Integer, LottoNo> lottoNumberMap = new HashMap<>();

  static {
    for (int i = 1; i <= 45; i++) {
      lottoNumberMap.put(i, new LottoNo(i));
    }
  }

  public static LottoNo of(Integer lottoNumber) {
    return lottoNumberMap.get(lottoNumber);
  }

  private LottoNo(Integer lottoNumber) {
    if (!valid(lottoNumber)) {
      throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자여야합니다.");
    }
    this.lottoNumber = lottoNumber;
  }

  private boolean valid(Integer lottoNumber) {
    return 1 <= lottoNumber && lottoNumber <= 45;
  }

  @Override
  public String toString() {
    return String.valueOf(lottoNumber);
  }

  @Override
  public int compareTo(LottoNo input) {
    return this.lottoNumber.compareTo(input.lottoNumber);
  }
}
