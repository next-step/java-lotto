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

    public static void printLottoRanks(List<LottoRank> lottoRanks) {
        System.out.println(STATISTICS_BANNER_MESSAGE);

        Map<Integer, Long> lottoRankMap = lottoRanks.stream()
                .collect(Collectors.groupingBy(LottoRank::getMatchCount, Collectors.counting()));

        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> !lottoRank.equals(LottoRank.BOOM))
                .sorted(Comparator.reverseOrder())
                .forEach(lottoRank -> printLottoRank(lottoRankMap, lottoRank));
    }

    private static void printLottoRank(Map<Integer, Long> lottoRankMap, LottoRank lottoRank) {
        Long matchCount = lottoRankMap.getOrDefault(lottoRank.getMatchCount(), 0l);
        String.format("%s개 일치 (%s원)- %s개", lottoRank.getMatchCount(), lottoRank.getPrice(), matchCount);

    }

    public static void printRevenueRate(double revenueRate) {
        System.out.println(PREFIX_REVENUE_MESSAGE + revenueRate + SUFFIX_REVENUE_MESSAGE);
    }
}
