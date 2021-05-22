package lotto.output;

import lotto.domain.LottoBucket;
import lotto.domain.LottoRoi;
import lotto.domain.MatchNumberCount;
import lotto.input.WinningNumber;
import lotto.input.PurchaseAmountQuantity;

public final class ResultView {

  public ResultView() {
  }

  public void printBy(PurchaseAmountQuantity purchaseAmountQuantity, LottoBucket lottoBucket, WinningNumber winningNumber) {
    MatchNumberCount matchNumberCount = lottoBucket.getMatchNumberCountWith(winningNumber);
    LottoRoi lottoRoi = purchaseAmountQuantity.getRoiBy(matchNumberCount);

    print(matchNumberCount, lottoRoi);
  }

  private void print(MatchNumberCount matchNumberCount, LottoRoi lottoRoi) {
    System.out.println("\n당첨 통계");
    System.out.println("---------");

    matchNumberCount.print();
    lottoRoi.print();
  }
}
