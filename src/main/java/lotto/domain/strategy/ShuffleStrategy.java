package lotto.domain.strategy;

import java.util.*;

import static lotto.domain.LottoNo.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNo.LOTTO_MIN_NUMBER;
import static lotto.domain.LottoTicket.CORRECT_LOTTO_TICKET_SIZE;

public class ShuffleStrategy implements LottoTicketCreateGenerator {
  private static final List<Integer> POSSIBLE_LOTTO_NUMBER_CANDIDATES;
  private static final int START_INDEX = 0;

  static {
    List<Integer> candidates = new ArrayList<>();
    for (int lottoNumber = LOTTO_MIN_NUMBER; lottoNumber <= LOTTO_MAX_NUMBER; lottoNumber++) {
      candidates.add(lottoNumber);
    }
    POSSIBLE_LOTTO_NUMBER_CANDIDATES = Collections.unmodifiableList(candidates);
  }

  @Override
  public Set<Integer> generate() {
    List<Integer> candidates = new ArrayList<>(POSSIBLE_LOTTO_NUMBER_CANDIDATES);
    Collections.shuffle(candidates);
    return new HashSet<>(candidates.subList(START_INDEX, CORRECT_LOTTO_TICKET_SIZE));
  }
}
