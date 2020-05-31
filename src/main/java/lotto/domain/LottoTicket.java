package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.collections.WinningNumbers;
import lotto.util.AutoLottoNumberGenerator;

public class LottoTicket {

  protected final List<LottoNumber> lottoNumbers;

  public LottoTicket() {
    lottoNumbers = new AutoLottoNumberGenerator().shuffle();
  }

  public int getMatchCounts(final WinningNumbers winningNumbers) {
    return Math.toIntExact(lottoNumbers.stream()
        .filter(number -> number.getMatchCounts(winningNumbers))
        .count());
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  @Override
  public String toString() {
    return "[" + lottoNumbers.stream()
        .map(Object::toString)
        .collect(Collectors.joining(", ")) + ']';
  }
}
