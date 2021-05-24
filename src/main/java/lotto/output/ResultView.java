package lotto.output;

import lotto.domain.LottoBucket;
import lotto.domain.LottoRoi;
import lotto.domain.MatchNumberCount;
import lotto.enums.Rank;
import lotto.input.WinningNumber;
import lotto.input.PurchaseAmountQuantity;

import java.util.Map;

import static lotto.enums.Rank.FIFTH;
import static lotto.enums.Rank.FIRST;
import static lotto.enums.Rank.FOURTH;
import static lotto.enums.Rank.SECOND;
import static lotto.enums.Rank.THIRD;

public final class ResultView {

  public ResultView() {
  }

  public void printBy(PurchaseAmountQuantity purchaseAmountQuantity, LottoBucket lottoBucket,
      WinningNumber winningNumber) {
    MatchNumberCount matchNumberCount = lottoBucket.getMatchNumberCountWith(winningNumber);
    LottoRoi lottoRoi = purchaseAmountQuantity.getRoiBy(matchNumberCount);

    print(matchNumberCount);
    print(lottoRoi);
  }

  private void print(MatchNumberCount matchNumberCount) {
    Map<Rank, Long> rankCount = matchNumberCount.getMatchNumberCount();

    System.out.println("3개 일치 (5000원)- " + rankCount.get(FIFTH) + "개");
    System.out.println("4개 일치 (50000원)- " + rankCount.get(FOURTH) + "개");
    System.out.println("5개 일치 (1500000)- " + rankCount.get(THIRD) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + rankCount.get(SECOND) + "개");
    System.out.println("6개 일치 (2000000000원)- " + rankCount.get(FIRST) + "개");
  }

  private void print(LottoRoi roi) {
    System.out.print("총 수익률은 " + roi.getValue() + "입니다.");

    if (roi.lessThan(1)) {
      System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
      return;
    }

    System.out.println("(기준이 1이기 때문에 결과적으로 이익이라는 의미임)");
  }
}
