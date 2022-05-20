package lotto.domain;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LottoFactory {

  private static final int LOTTO_NUMBERS_SIZE = 6;
  private static final String DELIMITER = ",";
  private static final List<LottoNumber> cachedLottoNumbers;

  static {
    cachedLottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
        .mapToObj(LottoNumber::from)
        .collect(toList());
  }

  public static List<Lotto> lotto(long numberOfLotto, List<String> lottoNumbers) {
    List<Lotto> lottos = lotto(numberOfLotto);
    lottos.addAll(lotto(lottoNumbers));
    return lottos;
  }

  public static List<Lotto> lotto(long numberOfLotto) {
    return LongStream.range(0, numberOfLotto)
        .mapToObj(number -> generateAutoLotto())
        .collect(toList());
  }

  public static List<Lotto> lotto(List<String> lottoNumbers) {
    return lottoNumbers.stream()
        .map(LottoFactory::lotto)
        .collect(toList());
  }

  public static Lotto lotto(String lottoNumbers) {
    if (isBlank(lottoNumbers)) {
      throw new IllegalArgumentException("로또 번호가 비어있습니다.");
    }
    return generateManual(lottoNumbers.split(DELIMITER));
  }

  private static Lotto generateAutoLotto() {
    Collections.shuffle(cachedLottoNumbers);
    return new Lotto(cachedLottoNumbers.stream()
        .limit(LOTTO_NUMBERS_SIZE)
        .collect(Collectors.toSet()));
  }

  private static Lotto generateManual(String... numbers) {
    return new Lotto(Arrays.stream(numbers)
        .map(LottoNumber::from)
        .collect(toSet()));
  }

  private static boolean isBlank(String numbers) {
    return numbers == null || numbers.isBlank();
  }

}
