package lotto.domain;

import lotto.domain.strategy.LottoTicketCreateGenerator;

import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNo.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNo.LOTTO_MIN_NUMBER;

public class LottoTicket {

  public static final int CORRECT_LOTTO_TICKET_SIZE = 6;
  public static final String INVALID_LOTTO_NUMBER_SIZE = "입력 개수를 다시 확인해주세요. input: %s";

  private final Set<LottoNo> lottoNumbers;

  private LottoTicket(Set<Integer> lottoNumbers) {

    if (lottoNumbers.size() != CORRECT_LOTTO_TICKET_SIZE) {
      throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_SIZE, lottoNumbers));
    }

    this.lottoNumbers = lottoNumbers.stream()
        .map(LottoNo::of)
        .collect(Collectors.toSet());
  }

  public static LottoTicket generate(LottoTicketCreateGenerator generator) {
    return new LottoTicket(generator.generate());
  }

  public static LottoTicket generate(Set<Integer> numbers) {
    return new LottoTicket(numbers);
  }

  public int size() {
    return lottoNumbers.size();
  }

  public boolean haveCorrectNumbers() {
    return lottoNumbers.stream()
        .allMatch(number -> LOTTO_MIN_NUMBER <= number.getNo() && number.getNo() <= LOTTO_MAX_NUMBER);
  }

  public boolean isSame(Set<LottoNo> numbers) {
    return this.lottoNumbers.equals(numbers);
  }

  public int getMatchCount(LottoTicket myLottoTicket) {
    return (int) this.lottoNumbers.stream()
        .filter(myLottoTicket.lottoNumbers::contains)
        .count();
  }

  public boolean contain(LottoNo value) {
    return this.lottoNumbers.contains(value);
  }

  public Set<LottoNo> getLottoNumbers() {
    return lottoNumbers;
  }
}
