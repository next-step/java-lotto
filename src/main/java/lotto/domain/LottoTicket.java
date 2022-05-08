package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

  private static final String EMPTY_LOTTO_NUMBERS = "로또 번호는 빈 값일 수 없습니다";
  private static final String LOTTO_NUMBERS_SIZE = "로또 번호는 6개여야 합니다";
  private static final String DUPLICATED_LOTTO_NUMBERS = "로또 번호가 중복될 수 없습니다";

  private final List<Integer> lottoNumbers;

  public LottoTicket(List<Integer> lottoNumbers) {
    checkLottoNullOrEmpty(lottoNumbers);
    checkLottoNumberSize(lottoNumbers);
    checkDuplicatedNumbers(lottoNumbers);

    this.lottoNumbers = lottoNumbers;
  }

  public LottoTicket(LottoTicket winLottoNumbers) {
    Objects.requireNonNull(winLottoNumbers, EMPTY_LOTTO_NUMBERS);
    this.lottoNumbers = List.copyOf(winLottoNumbers.lottoNumbers);
  }

  public List<Integer> getLottoNumbers() {
    return Collections.unmodifiableList(lottoNumbers);
  }

  private void checkLottoNullOrEmpty(List<Integer> lottoNumbers) {
    if (lottoNumbers == null || lottoNumbers.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_LOTTO_NUMBERS);
    }
  }

  private void checkLottoNumberSize(List<Integer> lottoNumbers) {
    if (lottoNumbers.size() != 6) {
      throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE);
    }
  }

  private void checkDuplicatedNumbers(List<Integer> lottoNumbers) {
    HashSet<Integer> hashSet = new HashSet<>(lottoNumbers);
    if (hashSet.size() != lottoNumbers.size()) {
      throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS);
    }
  }

  public int countMatched(LottoTicket winLotto) {
    return (int) lottoNumbers.stream()
        .filter(winLotto::contains)
        .count();
  }

  private boolean contains(Integer number) {
    return lottoNumbers.contains(number);
  }
}
