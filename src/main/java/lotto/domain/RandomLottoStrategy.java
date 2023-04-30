package lotto.domain;

import java.util.*;
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
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList());
  }

  @Override
  public LottoTicket issue() {
    Set<LottoNumber> randomLottoNumbers = new TreeSet<>();
    Collections.shuffle(lottoNumbers);

    for (int i = 0; i < TICKET_NUMBER_COUNT; i++) {
      randomLottoNumbers.add(lottoNumbers.get(i));
    }

    return new LottoTicket(randomLottoNumbers);
  }
}
