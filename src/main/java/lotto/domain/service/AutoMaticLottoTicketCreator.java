package lotto.domain.service;

import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.LottoTicket;

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

  @Override
  public LottoTicket pickLottoTicket() {
    List<LottoNumber> lottoNumbers = IntStream.range(MIN_LOTTO_NUMBERS, MAX_LOTTO_NUMBERS + ONE)
                                              .mapToObj(LottoNumber::new)
                                              .collect(toList());
    Collections.shuffle(lottoNumbers);
    return new LottoTicket(lottoNumbers.subList(FIRST_INDEX, LAST_INDEX));
  }
}
