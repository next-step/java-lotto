package me.daeho.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final RandomLottoNumberRule lottoNumberRule;
    private final LottoPrice lottoPrice;

    private LottoMachine(RandomLottoNumberRule lottoNumberRule, LottoPrice lottoPrice) {
        this.lottoNumberRule = lottoNumberRule;
        this.lottoPrice = lottoPrice;
    }

    public static LottoMachine create(RandomLottoNumberRule lottoNumberRule, LottoPrice lottoPrice) {
        return new LottoMachine(lottoNumberRule, lottoPrice);
    }

    private List<LottoTicket> buyRandom(LottoPurchase purchase) {
        return IntStream.range(0, purchase.randomCount(lottoPrice))
                .mapToObj(v -> LottoTicket.issue(lottoNumberRule.make()))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> buy(LottoPurchase lottoPurchase) {
        Optional.ofNullable(lottoPurchase)
                .orElseThrow(() -> new IllegalArgumentException("LottoPurchase must be not null"));

        final List<LottoTicket> lottoTickets = buyRandom(lottoPurchase);
        lottoTickets.addAll(lottoPurchase.manualTickets());
        return lottoTickets;
    }

    public TotalPrize totalPrize(Map<Rank, Integer> matchTicketRanks) {
        Optional.ofNullable(matchTicketRanks)
                .orElseThrow(() -> new IllegalArgumentException("matchTicketRanks must be not null"));

        int totalPrize = 0;
        for(Map.Entry<Rank, Integer> entry : matchTicketRanks.entrySet()) {
            int prize = Optional.ofNullable(entry.getKey())
                    .orElseThrow(() -> new IllegalArgumentException("Rank must be not null"))
                    .getPrize();

            Integer rankCount = Optional.ofNullable(entry.getValue())
                    .orElse(0);

            totalPrize += (prize * rankCount);
        }

        return TotalPrize.of(totalPrize);
    }

    public Map<Rank, Integer> matchTicketCounts(List<LottoNumber> lastWinningNumber, LottoNumber bonusBall, List<LottoTicket> tickets) {
        Optional.ofNullable(lastWinningNumber).orElseThrow(() -> new IllegalArgumentException("LastWinningNumber must be not null"));
        Optional.ofNullable(bonusBall).orElseThrow(() -> new IllegalArgumentException("BonusBall must be not null"));
        Optional.ofNullable(tickets).orElseThrow(() -> new IllegalArgumentException("Tickets must be not null"));

        final Map<Rank, Integer> rankCounts = new HashMap<>();
        tickets.forEach(t -> {
            int matchCount = t.containsCount(lastWinningNumber);
            Rank winningPrize = Rank.valueOf(matchCount, isMatchBonusBall(bonusBall, t));
            rankCounts.put(
                    winningPrize,
                    increaseMatchTicketCount(rankCounts, winningPrize)
            );
        });
        return rankCounts;
    }

    private boolean isMatchBonusBall(LottoNumber bonusBall, LottoTicket ticket) {
        Optional.ofNullable(bonusBall).orElseThrow(() -> new IllegalArgumentException("BonusBall must be not null"));
        Optional.ofNullable(ticket).orElseThrow(() -> new IllegalArgumentException("LottoTicket must be not null"));

        return ticket.containsCount(bonusBall) == 1;
    }

    private int increaseMatchTicketCount(Map<Rank, Integer> matchNumbers, Rank rank) {
        Optional.ofNullable(rank).orElseThrow(() -> new IllegalArgumentException("Rank must be not null"));
        Optional.ofNullable(matchNumbers).orElseThrow(() -> new IllegalArgumentException("MatchNumbers must be not null"));

        return matchNumbers.getOrDefault(rank, 0) + 1;
    }

    public EarningRate earningRate(LottoPurchase purchase, TotalPrize totalPrize) {
        Optional.ofNullable(purchase).orElseThrow(() -> new IllegalArgumentException("LottoPurchase must be not null"));
        Optional.ofNullable(totalPrize).orElseThrow(() -> new IllegalArgumentException("TotalPrize must be not null"));

        return totalPrize.earningRate(purchase.amount());
    }
}
