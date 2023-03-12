package lotto.ui;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketList;
import lotto.domain.enums.LottoRank;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private final LottoTicketList lottoTicketList;
    private final LottoHitInfo hitInfo;

    private LottoResult(LottoTicketList lottoTicketList, LottoHitInfo hitInfo) {
        this.lottoTicketList = lottoTicketList;
        this.hitInfo = hitInfo;
    }

    public static LottoResult from(final LottoTicketList lottoTicketList, final LottoHitInfo hitInfo) {
        return new LottoResult(lottoTicketList, hitInfo);
    }

    public void printWinningStatistics() {
        StringBuilder sb = new StringBuilder();

        Map<LottoRank, Integer> ranks = getRanks();

        Arrays.stream(LottoRank.values())
                .forEach(rank -> {
                    String statistic = createStatistic(ranks, rank);
                    sb.append(statistic).append("\n");
                });

        BigDecimal totalRate = calculateTotalRate(ranks);
        sb.append("총 수익률은 ").append(totalRate).append("% 입니다.").append("\n");
        System.out.println(sb);
    }

    private Map<LottoRank, Integer> getRanks() {
        Map<LottoRank, Integer> ranks = lottoTicketList.findRanks(hitInfo);
        return ranks;
    }

    private String createStatistic(Map<LottoRank, Integer> ranks, LottoRank rank) {
        return String.format("%s- %d개", rank, ranks.getOrDefault(rank, 0));
    }

    public BigDecimal calculateTotalRate(Map<LottoRank, Integer> ranks) {
        int sum = 0;

        Set<LottoRank> lottoRanks = ranks.keySet();

        for (LottoRank lottoRank : lottoRanks) {
            int hitCount = ranks.get(lottoRank);
            int rewarding = lottoRank.getRewarding();
            sum += rewarding * hitCount;
        }

        BigDecimal buyingPrice = lottoTicketList.calculateBuyingPrice();
        BigDecimal totalRewarding = new BigDecimal(sum);
        return totalRewarding.divide(buyingPrice, 2, RoundingMode.DOWN);
    }

    public void printLottoNumbers() {
        List<LottoTicket> lottoTickets = lottoTicketList.getLottoTickets();
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    public int findHitCount(LottoRank rank) {
        Map<LottoRank, Integer> ranks = getRanks();
        return ranks.getOrDefault(rank, 0);
    }
}
