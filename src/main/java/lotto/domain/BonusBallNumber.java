package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_END_NUMBER;
import static lotto.domain.LottoConstants.LOTTO_START_NUMBER;

public class BonusBallNumber {

  private final LottoNumber number;

  public static BonusBallNumber createBonusBallNumber(Integer number) {
    validate(number);
    return new BonusBallNumber(LottoNumber.valueOf(number));
  }

  public static BonusBallNumber createBonusBallNumber(LottoTicket lottoTicket, Integer number) {
    validate(lottoTicket, number);
    return new BonusBallNumber(LottoNumber.valueOf(number));
  }

  private static void validate(Integer number) {
    if (number == null) {
      throw new IllegalArgumentException("번호는 null일 수 없습니다.");
    }
  }

  private static void validate(LottoTicket lottoTicket, Integer number) {
    validate(number);
    if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
      throw new IllegalArgumentException(
          String.format("%d 보너스볼 범위는 %d ~ %d 범위 이내의 숫자여야 합니디.", number, LOTTO_START_NUMBER,
              LOTTO_END_NUMBER));
    }
    if (lottoTicket == null) {
      throw new IllegalArgumentException("로또 번호는 null일 수 없습니다.");
    }
    if (lottoTicket.contains(LottoNumber.valueOf(number))) {
      throw new IllegalArgumentException(
          String.format("%d: 보너스볼 번호는 로또 번호와 중복된 번호일 수 없습니다.", number));
    }
  }

  private BonusBallNumber(LottoNumber number) {
    validate(number);
    this.number = number;
  }

  private void validate(LottoNumber number) {
    if (number == null) {
      throw new IllegalArgumentException("LottoNumber null일 수 없습니다.");
    }
  }

  public boolean matchAny(LottoTicket lottoTicket) {
    if (lottoTicket == null) {
      throw new IllegalArgumentException("lottoTicket은 null일 수 없습니다.");
    }
    return lottoTicket.contains(number);
  }
}
