package lotto.domain;

import lotto.message.Message;
import lotto.service.Operation;

public class PurchaseCount {

  private static final int EACH_LOTTO_COST = 1000;

  private final int totalCount;

  private final int manualCount;

  public PurchaseCount(final LottoMoney lottoMoney, final int manualCount) {

    int count = lottoMoney.countLottoToMoney(Operation.DIVISION_SHARE, EACH_LOTTO_COST);
    validation(count, manualCount);

    this.totalCount = count;
    this.manualCount = manualCount;
  }

  private void validation(final int count, final int manualCount) {
    if (count - manualCount < 0) {
      throw new IllegalArgumentException(Message.MSG_ERROR_OVER_COUNT);
    }
  }

  public int getAutoCount() {
    return totalCount - manualCount;
  }

  public static int getTotalCount(PurchaseCount purchaseCount){
    return purchaseCount.totalCount;
  }

  @Override
  public String toString() {
    return "수동으로 " + manualCount + "장, 자동으로 " + getAutoCount() + Message.MSG_BUY_LOTTO_COUNT;
  }

}