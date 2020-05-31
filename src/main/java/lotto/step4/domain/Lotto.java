package lotto.step4.domain;

import lotto.step4.execption.LottoCountException;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Lotto {

  public static final long SIZE = 6L;
  public static final long PRICE = 1000L;
  private static final boolean IS_AUTO_LOTTO = true;
  private static final boolean IS_DIRECT_LOTTO = false;

  private final SortedSet<LottoNumber> lottoNumbers;
  private final boolean auto;

  private Lotto (SortedSet<LottoNumber> lottoNumbers, boolean auto) {
    this.auto = auto;
    this.lottoNumbers = lottoNumbers;
    validateCount();
  }

  public Stream<LottoNumber> stream () {
    return lottoNumbers.stream();
  }

  public boolean has (LottoNumber number) {
    return lottoNumbers.contains(number);
  }

  public boolean isAuto () {
    return auto;
  }

  public long sameCount (Lotto lotto) {
    SortedSet<LottoNumber> temp = new TreeSet<>(lottoNumbers);
    temp.retainAll(lotto.lottoNumbers);
    return temp.size();
  }

  public static Lotto of (List<LottoNumber> lottoNumbers) {
    return new Lotto(new TreeSet<>(lottoNumbers), IS_AUTO_LOTTO);
  }

  public static Lotto ofDirect (List<LottoNumber> lottoNumbers) {
    return new Lotto(new TreeSet<>(lottoNumbers), IS_DIRECT_LOTTO);
  }

  private void validateCount () throws RuntimeException {
    if (lottoNumbers.size() != SIZE) {
      throw new LottoCountException();
    }
  }
}
