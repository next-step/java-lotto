package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

  private static final int LOTTOSIZE = 6;
  private final Set<LottoNumber> lottoNumbers;


  private Lotto(Set<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static Lotto defaultOf() {
    Set<LottoNumber> lottoNumbers = new HashSet<>();
    while (lottoNumbers.size() != LOTTOSIZE) {
      lottoNumbers.add(LottoNumber.defaultOf());
    }
    return new Lotto(lottoNumbers);
  }

  public static Lotto defaultOf(Set<LottoNumber> lottoNumbers) {
    return new Lotto(lottoNumbers);
  }

  public static Lotto defaultOf(String lottoNumberString) {
    String[] split = lottoNumberString.split(",");
    Set<LottoNumber> lottoNumbers = new HashSet<>();
    for (String number : split) {
      LottoNumber lottoNumber = LottoNumber.of(Integer.parseInt(number));
      lottoNumbers.add(lottoNumber);
    }
    if (lottoNumbers.size() != LOTTOSIZE) {
      throw new IllegalArgumentException("로또번호는 같을 수 없습니다.");
    }
    return new Lotto(lottoNumbers);
  }

  public int size() {
    return this.lottoNumbers.size();
  }

  public int sameNumberCount(Lotto lotto) {
    int sameNumberCount = 0;
    for (LottoNumber lottoNumber : this.lottoNumbers) {
      sameNumberCount = judgeSameNumber(lotto, lottoNumber, sameNumberCount);
    }
    return sameNumberCount;
  }

  private int judgeSameNumber(Lotto lotto, LottoNumber lottoNumber, int sameNumberCount) {
    if (lotto.hasNumber(lottoNumber)) {
      sameNumberCount++;
    }
    return sameNumberCount;
  }

  private boolean hasNumber(LottoNumber comparingLottoNumber) {
    return this.lottoNumbers.stream()
        .anyMatch(comparingLottoNumber::equals);
  }


  public String toStringStatus() {
    StringBuilder stringBuilder = new StringBuilder();

    for (LottoNumber lottoNumber : this.lottoNumbers) {
      stringBuilder.append(lottoNumber.toString()).append(", ");
    }
    String status = stringBuilder.toString();
    int i = status.lastIndexOf(",");

    return status.substring(0, i);
  }

  public boolean has(LottoNumber bonusLottoNumber) {
    return lottoNumbers.contains(bonusLottoNumber);
  }
}
