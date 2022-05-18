package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_END_NUMBER;
import static lotto.domain.LottoConstants.LOTTO_START_NUMBER;

public class BonusBallNumber {

  private final Integer number;

  public static BonusBallNumber createBonusBallNumber(Integer number) {
    return new BonusBallNumber(number);
  }

  public static BonusBallNumber createBonusBallNumber(LottoTicket lottoTicket, Integer number) {
    validate(lottoTicket, number);
    return new BonusBallNumber(number);
  }

  private static void validate(LottoTicket lottoTicket, Integer number) {
    if (lottoTicket == null) {
      throw new IllegalArgumentException("로또 번호는 null일 수 없습니다.");
    }
    if (lottoTicket.contains(number)) {
      throw new IllegalArgumentException(
          String.format("%d: 보너스볼 번호는 로또 번호와 중복된 번호일 수 없습니다.", number));
    }
  }

  private BonusBallNumber(Integer number) {
    validate(number);
    this.number = number;
  }

  private void validate(Integer number) {
    if (number == null) {
      throw new IllegalArgumentException("보너스볼은 null일 수 없습니다.");
    }
    if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
      throw new IllegalArgumentException(String.format("%d 보너스볼 범위가 올바르지 않습니다.", number));
    }
  }

  public boolean matchAny(LottoTicket lottoTicket) {
    if (lottoTicket == null) {
      throw new IllegalArgumentException("lottoTicket은 null일 수 없습니다.");
    }
    return lottoTicket.contains(number);
  }
}
