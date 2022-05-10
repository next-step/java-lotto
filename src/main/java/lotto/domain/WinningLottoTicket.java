package lotto.domain;

import static java.util.stream.Collectors.toList;

import calculator.Splitter;

public class WinningLottoTicket extends LottoTicket {

  private static final String DELIMITER = ",";

  public WinningLottoTicket(String lottoNumbers) {
    super(Splitter.split(lottoNumbers, DELIMITER)
        .stream()
        .map(Integer::parseInt)
        .collect(toList()));
  }
}
