package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

  private static final int LOTTO_NUMBER_COUNT = 6;

  private static final List<LottoTicketNumber> ALL_LOTTO_NUMBERS = initializeLottoNumbers();

  private final List<LottoTicketNumber> lottoTickets;

  public LottoTicket() {
    this.lottoTickets = generateLottoTicket();
  }

  private static List<LottoTicketNumber> initializeLottoNumbers() {
    return IntStream.rangeClosed(LottoTicketNumber.getMinBound(), LottoTicketNumber.getMaxBound())
        .mapToObj(i -> new LottoTicketNumber())
        .collect(Collectors.toList());
  }

  private List<LottoTicketNumber> generateLottoTicket() {
    List<LottoTicketNumber> shuffledNumbers = new ArrayList<>(ALL_LOTTO_NUMBERS);
    Collections.shuffle(shuffledNumbers);
    List<LottoTicketNumber> selectedNumbers = shuffledNumbers.subList(0, LOTTO_NUMBER_COUNT);
    Collections.sort(selectedNumbers);
    return selectedNumbers;
  }

  public List<LottoTicketNumber> getLottoNumbers() {
    return lottoTickets;
  }
}
