package lotto.domain;

import lotto.common.LottoRank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 역할 - 티켓별 당첨개수를 구한다.
 */
public class LottoPack {

    private List<LottoTicket> lottoTickets;
    private int lottoPrice;

    public LottoPack(int lottoPrice, List<LottoTicket> lottoTickets) {
        validate(lottoTickets);

        this.lottoPrice = lottoPrice;
        this.lottoTickets = lottoTickets;
    }

    private void validate(List<LottoTicket> lottoTickets) {
        if (lottoTickets != null && !lottoTickets.isEmpty()) {
            return;
        }

        throw new IllegalArgumentException("잘못된 숫자의 티켓을 입력하셨습니다.");
    }

    public int ticketCount() {
        return lottoTickets.size();
    }

    public LottoMatchResult matchResult(String winningNumbers, String bonusNumber) {
        LottoTicket winningTicket = new LottoTicket(winningNumbers);
        LottoNumber bonus = new LottoNumber(bonusNumber);

        List<LottoRank> lottoRanks = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.matchCount(winningTicket, bonus))
                .sorted()
                .collect(toList());

        //calculate status
        Map<LottoRank, Integer> matchResult = calculateMatchResult(lottoRanks);

        //calculate profit
        double profit = calculateProfit(matchResult);

        return new LottoMatchResult(matchResult, profit);
    }

    private Map<LottoRank, Integer> calculateMatchResult(List<LottoRank> lottoRanks) {
        Map<LottoRank, List<LottoRank>> lottoRankListMap = lottoRanks.stream()
                .collect(groupingBy(Function.identity()));

        Map<LottoRank, Integer> matchResult = lottoRankListMap.keySet().stream()
                .collect(toMap(Function.identity(), lottoRank -> lottoRankListMap.get(lottoRank).size()));

        Stream.of(LottoRank.values())
                .forEach(lottoRank -> matchResult.putIfAbsent(lottoRank, 0));

        return matchResult;
    }

    private double calculateProfit(Map<LottoRank, Integer> matchResult) {
        int totalRewards = matchResult.keySet().stream()
                .mapToInt(rank -> rank.getReward() * matchResult.getOrDefault(rank, 0))
                .sum();

        return Math.ceil(totalRewards * 100.0 / (lottoTickets.size() * lottoPrice) ) / 100.0;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
