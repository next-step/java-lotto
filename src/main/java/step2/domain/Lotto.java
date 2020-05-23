package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

  private static final List<Integer> numbers = Arrays.stream(new int[99])
                                                     .map(v -> v + 1)
                                                     .boxed()
                                                     .collect(Collectors.toList());

  private final List<Integer> lottoNumbers;

  private Lotto (List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public Stream<Integer> stream () {
    return this.lottoNumbers.stream();
  }

  public static Lotto of () {
    Collections.shuffle(numbers);
    return of(numbers.stream().limit(6L).collect(Collectors.toList()));
  }

  public static Lotto of (List<Integer> numbers) {
    return new Lotto(numbers);
  }
}
