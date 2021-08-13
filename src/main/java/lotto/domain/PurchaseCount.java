package lotto.domain;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.message.Message;
import lotto.service.Operation;

public class PurchaseCount {

  private static final int EACH_LOTTO_COST = 1000;

  private final int totalCount;

  private final int manualCount;

  public PurchaseCount(final LottoMoney lottoMoney, final int manualCount) {
    this.totalCount = lottoMoney.countLottoToMoney(Operation.DIVISION_SHARE,EACH_LOTTO_COST);
    this.manualCount = manualCount;
  }

  public int getAutoCount() {
    return totalCount - manualCount;
  }

  public List<String> createManualNumbers(final Scanner scanner) {
    return IntStream.range(0, manualCount)
        .mapToObj(number -> scanner.nextLine()).collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return "수동으로 "+manualCount + "장, 자동으로 " + getAutoCount() + Message.MSG_BUY_LOTTO_COUNT;
  }

}