package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoTicket {

  private static final String EMPTY_LOTTO_NUMBERS = "로또 번호는 빈 값일 수 없습니다";
  private static final String LOTTO_NUMBERS_SIZE = "로또 번호는 6개여야 합니다";
  private static final String DUPLICATED_LOTTO_NUMBERS = "로또 번호가 중복될 수 없습니다";

  private final List<Integer> lottoNumbers;

  public LottoTicket(List<Integer> lottoNumbers) {
    if (lottoNumbers == null || lottoNumbers.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_LOTTO_NUMBERS);
    }

    if (lottoNumbers.size() != 6) {
      throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE);
    }

    HashSet<Integer> hashSet = new HashSet<>(lottoNumbers);
    if (hashSet.size() != lottoNumbers.size()) {
      throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS);
    }

    this.lottoNumbers = lottoNumbers;
  }
}
