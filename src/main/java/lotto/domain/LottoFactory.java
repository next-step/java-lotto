package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

  private static final int LOTTO_NUMBERS_SIZE = 6;

  public static final String DELIMITER = ",";

  private static final List<LottoNumber> allLottoNumbers = new ArrayList<>(
      LottoNumber.MAX_LOTTO_NUMBER);

  static {
    IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
        .forEach(number -> allLottoNumbers.add(LottoNumber.from(number)));
  }

  public static LottoTicket createAuto() {
    Collections.shuffle(allLottoNumbers);
    return new LottoTicket(allLottoNumbers.stream()
        .limit(LOTTO_NUMBERS_SIZE)
        .collect(Collectors.toList()));
  }

  public static LottoTicket createManual(String numbers) {
    if (isBlank(numbers)) {
      throw new IllegalArgumentException("로또 번호가 비어있습니다.");
    }
    return createManual(numbers.split(DELIMITER));
  }

  private static LottoTicket createManual(String... numbers) {
    return createManual(Arrays.stream(numbers)
        .map(LottoNumber::from)
        .collect(Collectors.toList()));
  }

  private static LottoTicket createManual(List<LottoNumber> lottoNumbers) {
    return new LottoTicket(lottoNumbers);
  }

  private static boolean isBlank(String numbers) {
    return numbers == null || numbers.isBlank();
  }

}
