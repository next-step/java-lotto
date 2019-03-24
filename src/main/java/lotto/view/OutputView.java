package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printTicketCount(LottoMoney lottoMoney) {
        System.out.println(lottoMoney.buy() + "개를 구매했습니다.");
    }

    public static void printTickets(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printRankResult(LottoMatcher lottoMatcher) {
        List<LottoRank> lottoRanks = sortLottoRank2(lottoMatcher);

        for (LottoRank lottoRank : lottoRanks) {
            determinePrintRankMessage(lottoMatcher, lottoRank);
        }
    }

    private static void determinePrintRankMessage(LottoMatcher lottoMatcher, LottoRank lottoRank) {
        if (lottoRank == LottoRank.MISS) return;

        if (lottoRank.money == LottoRank.SECOND.money) {
            System.out.println(lottoRank.number + "개 일치, 보너스 볼 일치("
                    + lottoRank.money + "원) - " + lottoMatcher.rankResult.get(lottoRank) + "개");
            return;
        }

        System.out.println(lottoRank.number + "개 일치 ("
                + lottoRank.money + "원) - " + lottoMatcher.rankResult.get(lottoRank) + "개");
    }

    private static List<LottoRank> sortLottoRank(LottoMatcher lottoMatcher) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        lottoRanks.addAll(lottoMatcher.rankResult.keySet());
        Collections.sort(lottoRanks, Collections.reverseOrder());
        return lottoRanks;
    }

    private static List<LottoRank> sortLottoRank2(LottoMatcher lottoMatcher) {
        LottoRank[] lottoRanks = LottoRank.values();
        List<LottoRank> lottoRankList = new ArrayList<>();
        for (LottoRank lottoRank : lottoRanks) {
            lottoRankList.add(lottoRank);
        }

        Collections.sort(lottoRankList, Collections.reverseOrder());
        return lottoRankList;
    }

    public static void printEarningRate(EarningRate earningRate) {
        String result = "총 수익률은 " + earningRate.toString() + "입니다.";
        if (earningRate.getRate() < 0) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.println(result);
    }
}
