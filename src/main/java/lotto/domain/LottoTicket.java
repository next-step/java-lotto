package lotto.domain;

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

  public LottoRank getWinLottoNumbers(WinLotto winLotto) {
    return LottoRank.of(countByMatched(winLotto.getLottoNumbers()), matchBonus(winLotto.getBonusNumber()));
  }

  private long countByMatched(List<LottoNumber> winLottoNumbers) {
    return lottoNumbers.stream()
        .filter(winLottoNumbers::contains)
        .count();
  }

  private boolean matchBonus(LottoNumber bonusNumber) {
    return lottoNumbers.stream()
        .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
  }

  public List<LottoNumber> getLottoNumbers() {
    return Collections.unmodifiableList(lottoNumbers);
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

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
