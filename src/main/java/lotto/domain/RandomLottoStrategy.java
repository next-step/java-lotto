package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.LottoTicket.TICKET_NUMBER_COUNT;

public class RandomLottoStrategy implements LottoStrategy {
  private final List<LottoNumber> lottoNumbers;

  public RandomLottoStrategy() {
    this.lottoNumbers = createLottoNumbers();
  }

  private static List<LottoNumber> createLottoNumbers() {
    return IntStream.rangeClosed(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
  }

  @Override
  public LottoTicket issue() {
    LottoTicket randomLottoTicket = new LottoTicket();
    Collections.shuffle(lottoNumbers);

    for (int i = 0; i < TICKET_NUMBER_COUNT; i++) {
      randomLottoTicket.addLottoNumber(lottoNumbers.get(i));
    }

    return randomLottoTicket;
  }
}
