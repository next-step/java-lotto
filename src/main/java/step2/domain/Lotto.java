package step2.domain;

import step2.exception.LottoCountException;
import step2.exception.LottoReduplicateException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

  private static final List<Integer> numbers = new ArrayList<>();
  static {
    for (int i = 1; i < 51; i++) numbers.add(i);
  }

  private final List<Integer> lottoNumbers;

  private Lotto (List<Integer> lottoNumbers) throws RuntimeException {
    validateCount(lottoNumbers);
    validateReduplicate(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public Stream<Integer> stream () {
    return lottoNumbers.stream();
  }

  public static Lotto of (String lottoNumbers) {
    return Lotto.of(
      Arrays.stream(lottoNumbers.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList())
    );
  }

  public static Lotto of () {
    Collections.shuffle(Lotto.numbers);
    return of(Lotto.numbers.stream().limit(6L).collect(Collectors.toList()));
  }

  public static Lotto of (List<Integer> lottoNumber) {
    lottoNumber.sort(Comparator.comparingInt(a -> a));
    return new Lotto(lottoNumber);
  }

  private static void validateCount (List<Integer> lottoNumbers) throws RuntimeException {
    if (lottoNumbers.size() != 6) {
      throw new LottoCountException();
    }
  }

  private static void validateReduplicate (List<Integer> lottoNumbers) throws RuntimeException {
    if (new HashSet(lottoNumbers).size() != lottoNumbers.size()) {
      throw new LottoReduplicateException();
    }
  }
}
