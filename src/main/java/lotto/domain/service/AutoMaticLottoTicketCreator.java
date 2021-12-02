package lotto.domain.service;

import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AutoMaticLottoTicketCreator implements LottoTicketCreator {

  private static final int MIN_LOTTO_NUMBERS = 1;
  private static final int MAX_LOTTO_NUMBERS = 45;
  private static final int ONE = 1;
  private static final int FIRST_INDEX = 0;
  private static final int LAST_INDEX = 6;

  private List<LottoNumber> lottoNumbers;

  public AutoMaticLottoTicketCreator() {
    this.lottoNumbers = IntStream.range(MIN_LOTTO_NUMBERS, MAX_LOTTO_NUMBERS + ONE)
                                 .mapToObj(LottoNumber::new)
                                 .collect(toList());
    Collections.sort(lottoNumbers);
  }

  @Override
  public LottoTicket pickLottoTicket() {
    Collections.shuffle(lottoNumbers);
    List<LottoNumber> numbers = new ArrayList<>(lottoNumbers.subList(FIRST_INDEX, LAST_INDEX));
    Collections.sort(numbers);
    return new LottoTicket(numbers);
  }
}
