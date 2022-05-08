package lotto.view;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

public class ResultView {

  public static void print(Lotto lotto) {
    for (LottoTicket lottoTicket : lotto.getLottoTickets()) {
      out.println(lottoTicket);
    }
  }

  public static void print(LottoResult lottoResult) {
    out.println("당첨 통계");
    out.println("---------");
    Arrays.stream(LottoRank.values())
        .sorted(Comparator.comparing(LottoRank::getCashPrize))
        .filter(LottoRank::isRewarded)
        .forEach(lottoRank -> out.println(
            lottoRank + "- " + lottoResult.getCountByLottoRank(lottoRank) + "개"));
    out.print("총 수익률은 " + lottoResult.getRateOfReturn() + "입니다.");
  }
}
