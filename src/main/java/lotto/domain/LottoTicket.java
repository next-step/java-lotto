package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;
  private static final List<Integer> POSSIBLE_LOTTO_NUMBER_CANDIDATES = makeCandidateNumbers();
  public static final String INVALID_LOTTO_NUMBER_INPUT = "해당 숫자는 로또 번호 범위가 아닙니다. 번호를 다시 확인해주세요. input: %s";
  public static final String INVALID_LOTTO_NUMBER_SIZE = "입력 개수를 다시 확인해주세요. input: %s";

  private final List<Integer> lottoNumbers;

  private LottoTicket(List<Integer> lottoNumbers) {

    if (Boolean.FALSE.equals(checkNumbersRange(lottoNumbers))) {
      throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_INPUT, lottoNumbers));
    }

    if (lottoNumbers.size() != 6) {
      throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_SIZE, lottoNumbers));
    }

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

  public static LottoTicket generate(List<Integer> winningNumbers) {
    return new LottoTicket(winningNumbers);
  }

  public int size() {
    return lottoNumbers.size();
  }

  public boolean haveCorrectNumbers() {
    return checkNumbersRange(this.lottoNumbers);
  }

  public boolean isSame(List<Integer> numbers) {
    return this.lottoNumbers.equals(numbers);
  }

  public int getMatchCount(LottoTicket myLottoTicket) {
    return (int) this.lottoNumbers.stream()
        .filter(myLottoTicket.lottoNumbers::contains)
        .count();
  }

  private static List<Integer> makeCandidateNumbers() {
    final List<Integer> candidates = new ArrayList<>();
    for (int lottoNumber = LOTTO_MIN_NUMBER; lottoNumber <= LOTTO_MAX_NUMBER; lottoNumber++) {
      candidates.add(lottoNumber);
    }
    return candidates;
  }

  private boolean checkNumbersRange(List<Integer> numbers) {
    return numbers.stream()
        .allMatch(number -> LOTTO_MIN_NUMBER <= number && number <= LOTTO_MAX_NUMBER);
  }
}
