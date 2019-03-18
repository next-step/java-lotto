package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {

  private static final int LOTTE_PRICE = 1000;

  public static List<Lotto> issue(int purchaseAmount) {

    int issueCount = purchaseAmount / LOTTE_PRICE;

    List<Lotto> lottoList = new ArrayList<>();
    for (int index = 0; index < issueCount; index++) {
      lottoList.add(new Lotto());
    }
    return lottoList;
  }
}
