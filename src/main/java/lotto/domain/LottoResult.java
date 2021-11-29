package lotto.domain;

import java.util.*;

public class LottoResult {
    private static final int INIT_COUNT = 0;
    private static final int INCREASE_NUMBER = 1;
    private static final int BASIC_UNIT = 1000;

    private final Map<Rank, Integer> lottoResult;
    private final int numberOfTickets;

    private LottoResult(Map<Rank, Integer> resultMap, int numberOfTickets) {
        this.lottoResult = resultMap;
        this.numberOfTickets = numberOfTickets;
    }

    public static LottoResult createResult(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        Map<Rank, Integer> resultMap = creatWinningRank(lottoTickets.getDetailTickets(), winningNumbers);
        return new LottoResult(resultMap, lottoTickets.size());
    }

    public double getProfitRate() {
        return calculateProfitRate();
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

    private double calculateProfitRate() {
        Integer profit = lottoResult.keySet()
                .stream()
                .map(Rank::getPrizeMoney)
                .reduce(0, Integer::sum);

        return formula(profit);
    }

    private double formula(int afterMoney) {
        return (double) afterMoney / (numberOfTickets * BASIC_UNIT);
    }

    private static Map<Rank, Integer> creatWinningRank(List<LottoTicket> lottoTickets, WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = createInitialMap();

        lottoTickets.forEach(
                lottoTicket -> calculateStatistic(lottoTicket, result, winningNumbers));

        return result;
    }

    private static Map<Rank, Integer> createInitialMap() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, INIT_COUNT));

        return result;
    }

    private static void calculateStatistic(LottoTicket lottoTicket,
                                           Map<Rank, Integer> resultMap,
                                           WinningNumbers winningNumbers) {
        int matchCount = lottoTicket.countMatchWinningNumber(winningNumbers.getNumbers());
        resultMap.put(
                Rank.matchRankOf(matchCount),
                resultMap.getOrDefault(Rank.matchRankOf(matchCount), INIT_COUNT) + INCREASE_NUMBER);
    }
}
