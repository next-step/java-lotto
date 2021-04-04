package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

  private final Lotto winningNumber;
  private final Number bonusBall;

  public WinningNumber(Lotto winningNumber, Number bonusBall) {
    this.winningNumber = winningNumber;
    this.bonusBall = bonusBall;
  }

  public static WinningNumber createWinningNumbers(Lotto winningNumber, Number bonusBall) {
    return new WinningNumber(winningNumber, bonusBall);
  }

  public LottoScoreBoard generateLottoMatchResult(WinningNumber winningNumber, LottoAgency agency) {
    List<LottoRank> lottoMatchResult = new ArrayList<>();
    for(int i = 0; i < agency.getPurchaseQuantity(); i++) {
      lottoMatchResult.add(eachLottoMatchResult(i, winningNumber, agency));
    }
    return LottoScoreBoard.createLottoResult(lottoMatchResult, agency.getSeedMoney());
  }

  private LottoRank eachLottoMatchResult(int index, WinningNumber winningNumber, LottoAgency agency) {
    List<Number> winningNumbers = getNumbers(winningNumber);
    List<Number> holdingLottoNumbers = getNumbers(index, agency);
    return LottoRank.matches(winningNumbers, holdingLottoNumbers, winningNumber.bonusBall);
  }

  private List<Number> getNumbers(int index, LottoAgency agency) {
    return agency.getCoupon()
        .getLottoCoupon()
        .get(index)
        .getNumbers();
  }

  private List<Number> getNumbers(WinningNumber winningNumber) {
    return winningNumber.winningNumber
        .getNumbers();
  }
}
