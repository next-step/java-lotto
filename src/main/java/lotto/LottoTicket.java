package lotto;

import java.util.Collections;
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

  public LottoResult getWinLottoNumbers(LottoTicket winLottoTicket) {
    return new LottoResult(getMatchedLottoNumberCount(winLottoTicket.getLottoNumbers()));
  }

  public List<LottoNumber> getLottoNumbers() {
    return Collections.unmodifiableList(lottoNumbers);
  }

  private int getMatchedLottoNumberCount(List<LottoNumber> winLottoNumbers) {
    int matchedCount = 0;
    for (LottoNumber lottoNumber : lottoNumbers) {
      if (winLottoNumbers.contains(lottoNumber)) {
        matchedCount++;
      }
    }
    return matchedCount;
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
}
