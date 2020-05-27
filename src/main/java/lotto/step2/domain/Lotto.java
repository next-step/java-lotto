package lotto.step2.domain;

import lotto.step2.exception.InvalidRangeNumberException;
import lotto.step2.exception.LottoCountException;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Lotto {

  public static final long SIZE = 6L;
  public static final int MIN_VALUE = 1;
  public static final int MAX_VALUE = 45;
  public static final long PRICE = 1000L;

  private final SortedSet<Integer> lottoNumbers;

  private Lotto (SortedSet<Integer> lottoNumbers) {
    validateCount(lottoNumbers);
    validateNumbers(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public Stream<Integer> stream () {
    return lottoNumbers.stream();
  }

  public boolean has (int number) {
    return lottoNumbers.contains(number);
  }

  public long sameCount (Lotto lotto) {
    return stream().filter(lotto::has).count();
  }

  public static Lotto of (List<Integer> lottoNumber) {
    return new Lotto(new TreeSet<>(lottoNumber));
  }

  private static void validateCount (SortedSet<Integer> lottoNumbers) throws RuntimeException {
    if (lottoNumbers.size() != SIZE) {
      throw new LottoCountException();
    }
  }

  private static void validateNumbers (SortedSet<Integer> lottoNumbers) throws RuntimeException {
    lottoNumbers
      .forEach(number -> {
        if (number < MIN_VALUE || number > MAX_VALUE) {
          throw new InvalidRangeNumberException();
        }
      });
  }
}
