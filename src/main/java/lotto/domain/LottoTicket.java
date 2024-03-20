package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;
  private static final List<Integer> POSSIBLE_LOTTO_NUMBER_CANDIDATES = makeCandidateNumbers();

  private final List<Integer> lottoNumbers;

  private LottoTicket(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static List<LottoTicket> generate(int ticketCount) {
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < ticketCount; i++) {
      Collections.shuffle(POSSIBLE_LOTTO_NUMBER_CANDIDATES);
      lottoTickets.add(new LottoTicket(POSSIBLE_LOTTO_NUMBER_CANDIDATES.subList(0, 6)));
    }
    return lottoTickets;
  }

  public int size() {
    return lottoNumbers.size();
  }

  public boolean haveCorrectNumbers() {
    return lottoNumbers.stream()
        .allMatch(number -> LOTTO_MIN_NUMBER <= number && number <= LOTTO_MAX_NUMBER);
  }

  private static List<Integer> makeCandidateNumbers() {
    final List<Integer> candidates = new ArrayList<>();
    for (int lottoNumber = LOTTO_MIN_NUMBER; lottoNumber <= LOTTO_MAX_NUMBER; lottoNumber++) {
      candidates.add(lottoNumber);
    }
    return candidates;
  }
}
