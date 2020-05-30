package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.collections.WinningNumbers;

public class LottoTicket {

  protected List<LottoNumber> lottoNumbers = new ArrayList<>();

  public LottoTicket() {
    lottoNumbers = drawAllNumbers();
    sortDescLottoNumbers();
  }

  private List<LottoNumber> drawAllNumbers() {
    final int LOTTO_NUMBER_SIZE = 6;
    for (int size = 0; size < LOTTO_NUMBER_SIZE; size++) {
      lottoNumbers.add(new LottoNumber());
    }
    return lottoNumbers;
  }

  public void sortDescLottoNumbers() {
    lottoNumbers.sort(Comparator.comparing(LottoNumber::getNumber));
  }

  public int getMatchCounts(WinningNumbers winningNumbers) {
    return Math.toIntExact(lottoNumbers.stream()
        .filter(number -> number.getMatchCounts(winningNumbers))
        .count());
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  @Override
  public String toString() {
    return "LottoTicket{" +
        "lottoNumbers=" + lottoNumbers +
        '}';
  }
}
