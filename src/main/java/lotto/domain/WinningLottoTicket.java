package lotto.domain;

import calculator.Splitter;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket extends LottoTicket {

  private static final String DELIMITER = ",";

  private final BonusBallNumber bonusBallNumber;

  public static WinningLottoTicket of(String lottoNumbers, String bonusNumber) {
    validate(lottoNumbers, bonusNumber);

    return new WinningLottoTicket(Splitter.splitAsList(lottoNumbers, DELIMITER),
        Integer.parseInt(bonusNumber));
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
    super(lottoNumbers.stream()
        .map(LottoNumber::valueOf)
        .collect(Collectors.toList()));
    this.bonusBallNumber = BonusBallNumber.createBonusBallNumber(this, bonusBallNumber);
  }

  public boolean matchBonusBall(LottoTicket lottoTicket) {
    if (lottoTicket == null) {
      throw new IllegalArgumentException("로또 티켓은 null 일 수 없습니다.");
    }
    return bonusBallNumber.matchAny(lottoTicket);
  }
}
