package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

  private static final List<Integer> numbers = new ArrayList<>();
  static {
    for (int i = 1; i < 51; i++) numbers.add(i);
  }

  private final List<Integer> lottoNumbers;

  private Lotto (List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public Stream<Integer> stream () {
    return this.lottoNumbers.stream();
  }

  public static Lotto of () {
    Collections.shuffle(numbers);
    List<Integer> lottoNumber = numbers.stream().limit(6L).collect(Collectors.toList());
    lottoNumber.sort((a, b) -> a - b);
    return of(lottoNumber);
  }

  public static Lotto of (List<Integer> numbers) {
    return new Lotto(numbers);
  }

  public static long getSames (Lotto lotto1, Lotto lotto2) {
    List<Integer> numbers = lotto2.stream().collect(Collectors.toList());
    return lotto1.stream().filter(numbers::contains).count();
  }
}
