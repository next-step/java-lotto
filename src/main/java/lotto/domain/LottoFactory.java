package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

  private static final int LOTTO_NUMBERS_SIZE = 6;
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;

  public static final String DELIMITER = ",";

  private static final List<LottoNumber> allLottoNumbers = new ArrayList<>(MAX_LOTTO_NUMBER);

  static {
    for (int number = MIN_LOTTO_NUMBER; number < MAX_LOTTO_NUMBER; number++) {
      allLottoNumbers.add(new LottoNumber(number));
    }
  }

  public static LottoTicket create() {
    Collections.shuffle(allLottoNumbers);
    return new LottoTicket(allLottoNumbers.stream()
        .limit(LOTTO_NUMBERS_SIZE)
        .collect(Collectors.toList()));
  }

  public static LottoTicket create(String numbers) {
    return create(numbers.split(DELIMITER));
  }

  public static LottoTicket create(String... numbers) {
    return create(Arrays.stream(numbers)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
  }

  public static LottoTicket create(Integer... numbers) {
    return create(Arrays.stream(numbers)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
  }

  private static LottoTicket create(List<LottoNumber> lottoNumbers) {
    return new LottoTicket(lottoNumbers);
  }

}
