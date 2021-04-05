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

  public LottoRank match(Lotto holdingNumbers) {
    return LottoRank.matches(this.winningNumber, holdingNumbers, this.bonusBall);
  }

  public LottoScoreBoard generateLottoMatchResult(LottoAgency agency) {
    List<LottoRank> lottoMatchResult = new ArrayList<>();
    for(int i = 0; i < agency.getPurchaseQuantity(); i++) {
      lottoMatchResult.add(eachLottoMatchResult(i, agency));
    }
    return LottoScoreBoard.createLottoResult(lottoMatchResult, agency.getSeedMoney());
  }

  private LottoRank eachLottoMatchResult(int index, LottoAgency agency) {
    return match(agency.getCoupon()
        .getLottoCoupon()
        .get(index));
  }
}
