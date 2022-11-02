package Lotto.View;

import Lotto.Lotto.LottoResult;
import Lotto.Lotto.LottoReward;
import Lotto.Lotto.LottoTicket;
import Lotto.Lotto.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTickets().size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket: lottoTickets.getLottoTickets()) {
            List<String> numbers = lottoTicket.getNumbers()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
            System.out.println("[" + String.join(", ", numbers) + "]");
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        printReward(lottoResult, LottoReward.FOURTH);
        printReward(lottoResult, LottoReward.THIRD);
        printReward(lottoResult, LottoReward.SECOND);
        printReward(lottoResult, LottoReward.FIRST);
        System.out.println("총 수익률은 " + lottoResult.profit() + "입니다." +
                (lottoResult.profit() < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : ""));
    }

    private static void printReward(LottoResult lottoResult, LottoReward lottoReward) {
        System.out.println(lottoReward.getMatchCount() + "개 일치 ("
                + lottoReward.getRewardMoney() + ")- "
                + lottoResult.getCount(lottoReward) + "개");
    }
}
