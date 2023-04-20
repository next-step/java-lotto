package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoStrategy implements LottoStrategy {
  private final List<LottoNumber> lottoNumbers;

  public RandomLottoStrategy() {
    this.lottoNumbers = createLottoNumbers();
  }

  private static List<LottoNumber> createLottoNumbers() {
    return IntStream.range(LottoNumber.LOTTO_MINIMUM_NUMBER, LottoNumber.LOTTO_MAXIMUM_NUMBER + 1)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
  }

  @Override
  public List<LottoNumber> issue() {
    Collections.shuffle(lottoNumbers);

    List<LottoNumber> randomLottoNumbers = new ArrayList<>();
    for (int i = 0; i < LottoTicket.TICKET_NUMBER_COUNT; i++) {
      randomLottoNumbers.add(lottoNumbers.get(i));
    }

    return randomLottoNumbers;
  }
}
