package lotto.domain;

import lotto.domain.strategy.LottoTicketCreateGenerator;

import java.util.Set;

public class LottoTicket {

  public static final String INVALID_LOTTO_NUMBER_INPUT = "해당 숫자는 로또 번호 범위가 아닙니다. 번호를 다시 확인해주세요. input: %s";
  public static final String INVALID_LOTTO_NUMBER_SIZE = "입력 개수를 다시 확인해주세요. input: %s";

  private final Set<Integer> lottoNumbers;

  private LottoTicket(Set<Integer> lottoNumbers) {

    if (!checkNumbersRange(lottoNumbers)) {
      throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_INPUT, lottoNumbers));
    }

    if (lottoNumbers.size() != 6) {
      throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_SIZE, lottoNumbers));
    }

    this.lottoNumbers = lottoNumbers;
  }

  public static LottoTicket generate(LottoTicketCreateGenerator generator) {
    return new LottoTicket(generator.generate());
  }

  public static LottoTicket generate(Set<Integer> winningNumbers) {
    return new LottoTicket(winningNumbers);
  }

  public int size() {
    return lottoNumbers.size();
  }

  public boolean haveCorrectNumbers() {
    return checkNumbersRange(this.lottoNumbers);
  }

  public boolean isSame(Set<Integer> numbers) {
    return this.lottoNumbers.equals(numbers);
  }

  public int getMatchCount(LottoTicket myLottoTicket) {
    return (int) this.lottoNumbers.stream()
        .filter(myLottoTicket.lottoNumbers::contains)
        .count();
  }

  public boolean contain(int value) {
    return this.lottoNumbers.contains(value);
  }

  private boolean checkNumbersRange(Set<Integer> numbers) {
    return numbers.stream()
        .allMatch(number ->
            LottoTicketCreateGenerator.minNumber() <= number &&
            number <= LottoTicketCreateGenerator.maxNumber()
        );
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
