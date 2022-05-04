package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

  private static final int LOTTO_NUMBERS_SIZE = 6;
  private final List<LottoNumber> lottoNumbers;

  public LottoTicket(List<LottoNumber> lottoNumbers) {
    validateSize(lottoNumbers);
    validateDuplicate(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  private void validateSize(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
      throw new IllegalArgumentException("로또 번호가 6자리가 아닙니다.");
    }
  }

  private void validateDuplicate(List<LottoNumber> lottoNumbers) {
    Set<LottoNumber> noDuplicateNumbers = new HashSet<>(lottoNumbers);
    if (noDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
      throw new IllegalArgumentException("로또 번호가 중복되었습니다.");
    }
  }

  public List<LottoNumber> getWinLottoNumbers(List<LottoNumber> winNumbers) {
    List<LottoNumber> winLottoNumbers = new ArrayList<>();
    for (LottoNumber lottoNumber : lottoNumbers) {
      if (winNumbers.contains(lottoNumber)) {
        winLottoNumbers.add(lottoNumber);
      }
    }
    return winLottoNumbers;
  }
}
