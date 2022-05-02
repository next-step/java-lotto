package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.ChoiceType;
import lotto.enums.Grade;
import lotto.exception.LottoLengthException;

public final class Lotto {

  private static final int DEFAULT_LOTTO_SIZE = 6;
  private final Set<LottoNumber> lottoNumbers;

  public Lotto(Set<LottoNumber> lottoNumbers) {
    valid(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public static Lotto from(Set<LottoNumber> winnerNumbers) {
    return new Lotto(winnerNumbers);
  }

  private void valid(Set<LottoNumber> lottoNumbers) {
    if (DEFAULT_LOTTO_SIZE != lottoNumbers.size()) {
      throw new LottoLengthException();
    }
  }

  public int coincideLotto(Grade grade, List<Lotto> allLotteryTickets) {
    int result = 0;
    for (Lotto lotto : allLotteryTickets) {
      result += increaseProductNumber(grade.getExpectNumber(), lotto).getIncreaseValue();
    }
    return result;
  }

  private ChoiceType increaseProductNumber(int expect, Lotto lotto) {
    int count = 0;
    for (LottoNumber winNumber : lotto.lottoNumbers) {
      count += containsWinnerNumber(
          Integer.parseInt(winNumber.toString())).getIncreaseValue();
    }
    if (expect == count) {
      return ChoiceType.GUESSED;
    }
    return ChoiceType.WRONG;
  }

  private ChoiceType containsWinnerNumber(Integer winNumber) {
    if (this.lottoNumbers.contains(new LottoNumber(winNumber))) {
      return ChoiceType.GUESSED;
    }
    return ChoiceType.WRONG;
  }

  public List<Integer> numbers() {
    return lottoNumbers.stream()
        .map(LottoNumber::currentNumber)
        .collect(Collectors.toList());
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
    return lottoNumbers.toString();
  }
}