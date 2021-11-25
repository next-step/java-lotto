package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoRandomMachine {

  public static List<LottoNumber> makeRandomLottoNumbers() {
    List<LottoNumber> shuffledLottoNumbers = makeShuffledLottoNumbers();
    return shuffledLottoNumbers.stream()
            .limit(Lotto.LOTTO_SIZE)
            .sorted()
            .collect(toList());
  }

  private static List<LottoNumber> makeShuffledLottoNumbers() {
    final List<LottoNumber> lottoNumbers = Stream.iterate(1, i -> i + 1)
            .limit(LottoNumber.MAX_NUMBER)
            .map(LottoNumber::new)
            .collect(toList());

    Collections.shuffle(lottoNumbers);
    return lottoNumbers;
  }

}
