package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator implements LottoGenerator{

  private final static int FROM_INDEX = 0;

  public Lotto generate() {

    List<LottoNumber> lottoNumbers = IntStream.range(LottoNumber.MINIMUM, LottoNumber.MAXIMUM)
        .mapToObj(LottoNumber::getInstance)
        .collect(Collectors.toList());
    Collections.shuffle(lottoNumbers);

    return new Lotto(
        new HashSet<>(
            lottoNumbers.subList(FROM_INDEX, FROM_INDEX + Lotto.NUMBERS_SIZE)
        )
    );
  }

  public List<Lotto> generate(int quantity) {

    return IntStream.range(0, quantity)
        .mapToObj(index -> generate())
        .collect(Collectors.toList());
  }

}
