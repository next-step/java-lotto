package step2.domain;

import step2.exception.LottoCountException;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Collections.shuffle;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lotto {

  private static final long MAX_COUNT = 6L;

  private static final List<Integer> numbers = new ArrayList<>();

  static {
    for (int i = 1; i < 46; i++) numbers.add(i);
  }

  private final Set<Integer> lottoNumbers;

  private Lotto (Set<Integer> lottoNumbers) {
    validateCount(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public Stream<Integer> stream () {
    return lottoNumbers.stream();
  }

  public boolean has (int number) {
    return lottoNumbers.contains(number);
  }

  public static Lotto of (String lottoNumbers) {
    return Arrays.stream(lottoNumbers.split(","))
                 .map(Integer::parseInt)
                 .collect(collectingAndThen(toList(), Lotto::of));
  }

  public static Lotto of () {
    shuffle(numbers);
    return numbers.stream()
                  .limit(MAX_COUNT)
                  .collect(collectingAndThen(toList(), Lotto::of));
  }

  public static Lotto of (List<Integer> lottoNumber) {
    lottoNumber.sort(comparingInt(a -> a));
    return new Lotto(new HashSet<>(lottoNumber));
  }

  private static void validateCount (Set<Integer> lottoNumbers) throws RuntimeException {
    if (lottoNumbers.size() != MAX_COUNT) {
      throw new LottoCountException();
    }
  }
}
