package lotto.domain;

import static java.util.stream.Collectors.toList;

import calculator.Splitter;
import java.util.List;

public class WinNumbers {

  private static final String EMPTY_WIN_NUMBERS = "당첨번호는 빈 값일 수 없습니다.";
  private static final String DELIMITER = ",";

  private final LottoTicket winLottoNumbers;

  public WinNumbers(String winNumbers) {
    if (winNumbers == null || winNumbers.isBlank()) {
      throw new IllegalArgumentException(EMPTY_WIN_NUMBERS);
    }

    List<Integer> lottoNumbers = Splitter.split(winNumbers, DELIMITER)
        .stream()
        .map(Integer::parseInt)
        .collect(toList());
    this.winLottoNumbers = new LottoTicket(lottoNumbers);
  }

  public LottoTicket getTicket() {
    return new LottoTicket(winLottoNumbers);
  }
}
