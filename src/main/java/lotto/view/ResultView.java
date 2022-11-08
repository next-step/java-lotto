package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.Rank.NO_MATCH;
import static lotto.domain.Rank.SECOND;

public class ResultView {

    private ResultView() {
    }

    public static void viewCountOfLotto(int countOfManualLottoSize, int countOfRandomLottoSize) {
        System.out.println(String.format("수동으 %d, 자동으로 %d개를 구매했습니다.", countOfManualLottoSize, countOfRandomLottoSize));
    }

    public static void viewLottoTickets(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
    }

    public static void viewWinningStatics(final LottoResult lottoResult, final Money money) {
        System.out.println();
        System.out.println("당첨 통계\n---------");

        Map<Rank, Long> result = lottoResult.getResult();
        List<Rank> ranks = Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        for (Rank rank : ranks) {
            viewRank(result, rank);
        }

        System.out.println("총 수익률 " + lottoResult.calculateRateOfReturn(money) + "입니다.");
    }

    private static void viewRank(final Map<Rank, Long> result, final Rank rank) {
        if (NO_MATCH == rank) {
            return;
        }

        System.out.printf("%d개 일치%s(%d원) - %d개%n", rank.getCountOfMatch(), getAdditionalMsg(rank), rank.getWinningMoney(), getCount(result, rank));
    }

    private static String getAdditionalMsg(final Rank rank) {
        if (SECOND == rank) {
            return  ", 보너스 볼 일치";
        }
        return "";
    }

    private static long getCount(final Map<Rank, Long> result, final Rank rank) {
        long count = 0;
        if (result.containsKey(rank)) {
            count = result.get(rank);
        }
        return count;
    }
}
