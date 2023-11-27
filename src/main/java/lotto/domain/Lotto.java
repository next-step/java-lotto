package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  private List<LottoNumber> lottoNumbers;
  private static final int LOTTOSIZE = 6;


  private Lotto(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static Lotto defaultOf() {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (int i = 0; i < LOTTOSIZE; i++) {
      i = judgeSameNumbers(lottoNumbers, i);
    }
    return new Lotto(lottoNumbers);
  }

  private static int judgeSameNumbers(List<LottoNumber> lottoNumbers, int i) {
    LottoNumber lottoNumber = LottoNumber.defaultOf();
    if (lottoNumbers.contains(lottoNumber)) {
      i--;
      return i;
    }
    lottoNumbers.add(lottoNumber);
    return i;
  }

  public static Lotto defaultOf(List<LottoNumber> lottoNumbers) {
    return new Lotto(lottoNumbers);
  }
  public static Lotto defaultOf(String lottoNumberString) {
    String[] split = lottoNumberString.split(",");
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (String number: split) {
      LottoNumber lottoNumber = LottoNumber.of(Integer.parseInt(number));
      lottoNumbers.add(lottoNumber);
    }
    return new Lotto(lottoNumbers);
  }

  public int size() {
    return this.lottoNumbers.size();
  }

  public int howManySameNumber(Lotto lotto) {
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

    stringBuilder.append("[");
    for (LottoNumber lottoNumber : this.lottoNumbers) {
      stringBuilder.append(lottoNumber.toString()).append(", ");
    }
    String status = stringBuilder.toString();
    int i = status.lastIndexOf(",");
    String lastStatus = status.substring(0, i);

    return lastStatus + "]";
  }
}
