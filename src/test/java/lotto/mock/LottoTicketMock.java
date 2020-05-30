package lotto.mock;

import java.util.ArrayList;
import java.util.List;
import lotto.collections.WinningNumbers;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class LottoTicketMock extends LottoTicket {

  List<LottoNumber> lottoNumbers;

  public LottoTicketMock(List<Integer> lottoNumberLists) {
    this.lottoNumbers = getLottoNumbersMock(lottoNumberLists);
  }

  @Override
  public int getMatchCounts(WinningNumbers winningNumbers) {
    return Math.toIntExact(lottoNumbers.stream()
        .filter(number -> number.getMatchCounts(winningNumbers))
        .count());
  }

  private List<LottoNumber> getLottoNumbersMock(List<Integer> lottoNumberLists) {
    List<LottoNumber> numbers = new ArrayList<>();
    for (int number: lottoNumberLists) {
      numbers.add(new LottoNumberMock(number));
    }
    return numbers;
  }

}
