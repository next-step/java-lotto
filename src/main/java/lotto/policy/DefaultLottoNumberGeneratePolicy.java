package lotto.policy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoNumberGeneratePolicy implements LottoNumberGeneratePolicy {
  private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45)
                                                             .boxed()
                                                             .collect(Collectors.toList());

  @Override
  public List<Integer> generateNumbers() {
    Collections.shuffle(lottoNumbers);
    return new ArrayList<>(lottoNumbers.subList(0, 6));
  }
}
