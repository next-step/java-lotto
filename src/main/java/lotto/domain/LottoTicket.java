package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final String EMPTY_LOTTO_NUMBERS = "로또 번호는 빈 값일 수 없습니다";
  private static final String VALID_LOTTO_NUMBERS_SIZE = String.format("로또 번호는 %d개여야 합니다",
      LOTTO_NUMBER_COUNT);
  private static final String DUPLICATED_LOTTO_NUMBERS = "[%s] 중복된 번호 포함. 로또 번호가 중복될 수 없습니다";

  private final List<Integer> lottoNumbers;

  public LottoTicket(List<Integer> lottoNumbers) {
    validateLottoNumbers(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  private void validateLottoNumbers(List<Integer> lottoNumbers) {
    if (lottoNumbers == null || lottoNumbers.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_LOTTO_NUMBERS);
    }
    if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(VALID_LOTTO_NUMBERS_SIZE);
    }
    HashSet<Integer> hashSet = new HashSet<>(lottoNumbers);
    if (hashSet.size() != lottoNumbers.size()) {
      String numbers = lottoNumbers.stream().map(Object::toString).collect(Collectors.joining(","));
      throw new IllegalArgumentException(String.format(DUPLICATED_LOTTO_NUMBERS, numbers));
    }
  }

  public LottoTicket(LottoTicket winLottoNumbers) {
    Objects.requireNonNull(winLottoNumbers, EMPTY_LOTTO_NUMBERS);
    this.lottoNumbers = List.copyOf(winLottoNumbers.lottoNumbers);
  }

  public List<Integer> getLottoNumbers() {
    return Collections.unmodifiableList(lottoNumbers);
  }

  public int countMatched(LottoTicket lottoTicket) {
    return (int) lottoNumbers.stream()
        .filter(lottoTicket::contains)
        .count();
  }

  public boolean bonusMatched(Integer bonusNumber) {
    return contains(bonusNumber);
  }

  private boolean contains(Integer number) {
    return lottoNumbers.contains(number);
  }

  @Override
  public String toString() {
    return "LottoTicket{" +
        "lottoNumbers=" + lottoNumbers +
        '}';
  }
}
