package lotto.view;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Rank;

public class ResultView {

  public static void print(long autoLottoCount) {
    out.println(autoLottoCount + "개를 구매했습니다.");
  }

  public static void print(LottoTicket lottoTicket) {
    for (Lotto lotto : lottoTicket.getLottos()) {
      out.println(lotto);
    }
  }

  public static void print(LottoResult lottoResult, Money money) {
    out.println("당첨 통계");
    out.println("---------");
    Arrays.stream(Rank.values())
        .sorted(Comparator.comparing(Rank::getCashPrize))
        .filter(Rank::isRewarded)
        .forEach(rank -> out.println(rank + "- " + lottoResult.countByRank(rank) + "개"));
    out.print("총 수익률은 " + money.rateOfReturn(lottoResult.totalPrizeAmount()) + "입니다.");
  }

}
