package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

  private LottoNumbers lottoNumbers;

  public static final String LAST_WEEK_LOTTO_NUMBERS_DELIMITER = ",";

  public Lotto() {
    this.lottoNumbers = NumbersBox.getLottoNumbers();
  }

  public Lotto(List<Integer> autoNumber) {
    lottoNumbers = makeLottoNumbers(autoNumber);
  }

  public Lotto(String input) {
    lottoNumbers = makeLottoNumbers(getLastWeekWinLotto(input));
  }

  private LottoNumbers makeLottoNumbers(List<Integer> autoNumber) {
    return new LottoNumbers(autoNumber.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
  }

  private List<Integer> getLastWeekWinLotto(String lastWeekWinLottoNumber) {
    return Arrays
        .stream(lastWeekWinLottoNumber.split(LAST_WEEK_LOTTO_NUMBERS_DELIMITER))
        .map(number -> number.trim())
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public int countSameNumber(Lotto lotto) {
    return lottoNumbers.countSameNumber(lotto.getNumbers());
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

}
