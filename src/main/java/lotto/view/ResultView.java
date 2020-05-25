package lotto.view;

import lotto.LottoRank;
import lotto.LottoTicket;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String SUFFIX_BUY_MESSAGE = "를 구매했습니다.";

    private static final String STATISTICS_BANNER_MESSAGE = "당첨 통계\n---------";

    private static final String PREFIX_REVENUE_MESSAGE = "총 수익율은 ";
    private static final String SUFFIX_REVENUE_MESSAGE = " 입니다.";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printBuyingTickets(List<LottoTicket> lottoTickets) {

        System.out.println(lottoTickets.size() + SUFFIX_BUY_MESSAGE);

        lottoTickets.stream()
                .map(LottoTicket::getLottoNumbers)
                .forEach(System.out::println);
    }

    public static void printLottoRanks(Map<LottoRank, Long> lottoRankMap) {
        System.out.println(STATISTICS_BANNER_MESSAGE);

        LottoRank.valuesWithOutBoom()
                .forEach(lottoRank -> printLottoRankMap(lottoRankMap, lottoRank));
    }

    private static void printLottoRankMap(Map<LottoRank, Long> lottoRankMap, LottoRank lottoRank) {
        Long count = lottoRankMap.getOrDefault(lottoRank, 0l);
        String message = String.format("%s개 일치 (%s원)- %s개", lottoRank.getMatchCount(), lottoRank.getPrice(), count);
        System.out.println(message);
    }

    public static void printRevenueRate(double revenueRate) {
        System.out.println(PREFIX_REVENUE_MESSAGE + revenueRate + SUFFIX_REVENUE_MESSAGE);
    }
}
