package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoTicket {

  public static final int TICKET_NUMBER_COUNT = 6;
  private static final String ILLEGAL_COUNT_MESSAGE = "로또 번호는 6개 입력하셔야 합니다.";
  private final Set<LottoNumber> lottoTicket;

  public LottoTicket() {
    lottoTicket = new TreeSet<>();
  }

  public LottoTicket(List<LottoNumber> lottoNumbers) {
    validateLottoTicket(lottoNumbers);

    lottoTicket = new TreeSet<>(lottoNumbers);
  }

  public Set<LottoNumber> lottoTicketNumbers() {
    return Collections.unmodifiableSet(lottoTicket);
  }

  public void addLottoNumber(LottoNumber lottoNumber) {
    lottoTicket.add(lottoNumber);
  }

  public int matchLottoCount(LottoTicket lottoNumbers) {
    return (int) lottoTicket.stream()
            .filter(lottoNumbers::containsLottoNumbers)
            .count();
  }

  private boolean containsLottoNumbers(LottoNumber lottoNumber) {
    return lottoTicket.contains(lottoNumber);
  }

  private void validateLottoTicket(List<LottoNumber> lottoTicket) {
    if (!equalsLottoNumbers(lottoTicket)) {
      throw new IllegalArgumentException(ILLEGAL_COUNT_MESSAGE);
    }
  }

  private boolean equalsLottoNumbers(List<LottoNumber> lottoTicket) {
    return lottoTicket.size() == TICKET_NUMBER_COUNT;
  }
}
