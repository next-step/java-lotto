package lotto.step3.domain;

import lotto.step2.exception.LottoCountException;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Lotto {

  public static final long SIZE = 6L;
  public static final long PRICE = 1000L;

  private final SortedSet<LottoNumber> lottoNumbers;

  private Lotto (SortedSet<LottoNumber> lottoNumbers) {
    validateCount(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public Stream<LottoNumber> stream () {
    return lottoNumbers.stream();
  }

  public boolean has (LottoNumber number) {
    return lottoNumbers.contains(number);
  }

  public long sameCount (Lotto lotto) {
    SortedSet<LottoNumber> temp = new TreeSet<>(lottoNumbers);
    temp.retainAll(lotto.lottoNumbers);
    return temp.size();
  }

  public static Lotto of (List<LottoNumber> lottoNumbers) {
    return new Lotto(new TreeSet<>(lottoNumbers));
  }

  private static void validateCount (SortedSet<LottoNumber> lottoNumbers) throws RuntimeException {
    if (lottoNumbers.size() != SIZE) {
      throw new LottoCountException();
    }
  }
}
