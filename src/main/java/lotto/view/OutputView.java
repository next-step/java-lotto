package lotto.view;

import lotto.lotto.*;

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

    public static void printResult(LottoMoney lottoMoney, LottoResult lottoResult) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---------");
        for (LottoReward lottoReward: LottoReward.values()) {
            printReward(lottoResult, lottoReward);
        }
        System.out.println("총 수익률은 " + lottoResult.profit(lottoMoney) + "입니다." +
                (lottoResult.profit(lottoMoney) < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : ""));
    }

    private static void printReward(LottoResult lottoResult, LottoReward lottoReward) {
        if (lottoReward.equals(LottoReward.NO)) {
            return ;
        }

        System.out.println(lottoReward.getMatchCount() + "개 일치 ("
                + lottoReward.getRewardMoney() + ")- "
                + lottoResult.getCount(lottoReward) + "개");
    }
}
