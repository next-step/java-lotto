package step2.domain;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

  private static final List<Integer> numbers = Arrays.stream(new int[99])
                                                     .map(v -> v + 1)
                                                     .boxed()
                                                     .collect(Collectors.toList());

  private final List<Integer> lottoNumbers;

  public Lotto () {
    this(Lotto.numbers);
  }

  public Lotto (List<Integer> lottoNumbers) {
    Collections.shuffle(lottoNumbers);
    this.lottoNumbers = lottoNumbers.stream().limit(6L).collect(Collectors.toList());
  }

  public Stream<Integer> stream () {
    return this.lottoNumbers.stream();
  }
}
