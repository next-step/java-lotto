package lotto.domain;

import static java.util.stream.Collectors.toList;

import calculator.Splitter;
import java.util.List;

public class WinningLottoTicket extends LottoTicket {

  private static final String DELIMITER = ",";

  private final Integer bonusBallNumber;

  public static WinningLottoTicket of(String lottoNumbers, String bonusNumber) {
    validate(lottoNumbers, bonusNumber);

    return new WinningLottoTicket(Splitter.split(lottoNumbers, DELIMITER)
        .stream()
        .map(Integer::parseInt)
        .collect(toList()), Integer.parseInt(bonusNumber));
  }

  private static void validate(String lottoNumbers, String bonusNumber) {
    if (lottoNumbers == null || lottoNumbers.isBlank()) {
      throw new IllegalArgumentException("우승로또는 빈 값일 수 없습니다.");
    }

    if (bonusNumber == null || bonusNumber.isBlank()) {
      throw new IllegalArgumentException("보너스 번호는 빈 값일 수 없습니다.");
    }
  }

  private WinningLottoTicket(List<Integer> lottoNumbers, Integer bonusBallNumber) {
    super(lottoNumbers);
    this.bonusBallNumber = bonusBallNumber;
  }

  public boolean matchBonusBall(LottoTicket lottoTicket) {
    if (lottoTicket == null) {
      throw new IllegalArgumentException("로또 티켓은 null 일 수 없습니다.");
    }
    return lottoTicket.contains(bonusBallNumber);
  }
}
