package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

  private LottoNumbers lottoNumbers;

  public Lotto() {
    this.lottoNumbers = new NumbersBox().getLottoNumbers();
  }

  public Lotto(List<Integer> autoNumber) {
    lottoNumbers = new LottoNumbers(autoNumber.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
  }

  public LottoNumbers getNumbers() {
    return lottoNumbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(lottoNumbers, lotto.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return "Lotto{" +
        "lottoNumbers=" + lottoNumbers +
        '}';
  }

  public int countSameNumber(Lotto lotto) {
    return lottoNumbers.countSameNumber(lotto.getNumbers());
  }

}
