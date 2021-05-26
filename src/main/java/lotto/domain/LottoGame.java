package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoGame {

  private final LottoNumbers gameNumbers;

  private final OrderType orderType;

  private LottoGame(LottoNumbers gameNumbers, OrderType orderType) {
    this.gameNumbers = gameNumbers;
    this.orderType = orderType;
  }

  public static LottoGame createAutoGame(LottoNumbers lottoNumbers) {
    return new LottoGame(lottoNumbers, OrderType.AUTO);
  }

  public static LottoGame createManualGame(LottoNumbers lottoNumbers) {
    return new LottoGame(lottoNumbers, OrderType.MANUAL);
  }

  public int matchWinningNumbers(LottoGame winningGame) {
    return gameNumbers.match(winningGame.gameNumbers);
  }

  public boolean matchBonusNumber(LottoNumber bonusNumber) {
    return gameNumbers.contains(bonusNumber);

  }

  public List<Integer> getGameNumbers() {
    return gameNumbers.getNumbers();
  }

  public String getOrderTypeName() {
    return orderType.getDisplayName();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoGame lottoGame = (LottoGame) o;
    return gameNumbers.equals(lottoGame.gameNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gameNumbers);
  }
}
