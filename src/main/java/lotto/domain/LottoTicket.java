package lotto.domain;

import java.util.List;

public class LottoTicket {

  public static final int TICKET_NUMBER_COUNT = 6;
  private static final String ILLEGAL_COUNT_MESSAGE = "로또 번호는 6개 입력하셔야 합니다.";
  private final List<LottoNumber> lottoTicket;

  public LottoTicket(LottoStrategy lottoStrategy) {
    this.lottoTicket = validatedLottoTicket(lottoStrategy.issue());
  }

  public int matchLottoCount(LottoTicket lottoNumbers) {
    return (int) lottoTicket.stream()
            .filter(lottoNumbers::containsLottoNumbers)
            .count();
  }

  private boolean containsLottoNumbers(LottoNumber lottoNumber) {
    return lottoTicket.contains(lottoNumber);
  }

  private List<LottoNumber> validatedLottoTicket(List<LottoNumber> lottoTicket) {
    if (!equalsLottoNumbers(lottoTicket)) {
      throw new IllegalArgumentException(ILLEGAL_COUNT_MESSAGE);
    }
    return lottoTicket;
  }

  private boolean equalsLottoNumbers(List<LottoNumber> lottoTicket) {
    return lottoTicket.size() == TICKET_NUMBER_COUNT;
  }
}
