package lotto.domain;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

  private static final int LOTTO_NUMBERS_SIZE = 6;
  private static final String DELIMITER = ",";
  private static final List<LottoNumber> cachedLottoNumbers;

  static {
    cachedLottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
        .mapToObj(LottoNumber::from)
        .collect(toList());
  }

  public static LottoTicket generateAuto(int numberOfLotto) {
    return new LottoTicket(IntStream.range(0, numberOfLotto)
        .mapToObj(number -> generateAuto())
        .collect(toList()));
  }

  public static Lotto generateManual(List<Integer> lottoNumbers) {
    return new Lotto(lottoNumbers);
  }

  private static Lotto generateAuto() {
    Collections.shuffle(cachedLottoNumbers);
    return new Lotto(cachedLottoNumbers.stream()
        .limit(LOTTO_NUMBERS_SIZE)
        .collect(Collectors.toSet()));
  }

  private static boolean isBlank(String numbers) {
    return numbers == null || numbers.isBlank();
  }

}
