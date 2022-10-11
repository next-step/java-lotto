package lotto;

import java.util.*;

public class LottoAutoCalculateStrategy implements LottoCalculateStrategy {
    private static final Money LOTTO_TICKET_PRICE = new Money(1000);
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int WINNING_LOTTO_COUNT = 6;
    private static final List<Lotto> lottoCandidates = new ArrayList<>();

    static {
        for (int i = 0; i < MAX_LOTTO_NUMBER; i++) {
            lottoCandidates.add(new Lotto(i + 1));
        }
    }

    @Override
    public int calculateLottoTicketCount(Money money) {
        return money.countBy(LOTTO_TICKET_PRICE);
    }

    @Override
    public List<List<Lotto>> buyLottoes(int ticketCount) {
        List<List<Lotto>> lottoes = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Collections.shuffle(lottoCandidates);
            List<Lotto> lottos = new ArrayList<>(lottoCandidates.subList(0, WINNING_LOTTO_COUNT));
            lottos.sort(Comparator.comparing(Lotto::getNumber));
            lottoes.add(lottos);
        }
        return lottoes;
    }

    @Override
    public Statistics calculateStatistics(List<List<Lotto>> lottoes, List<Lotto> winningLottoes, Money buyAmount) {
        Map<WinningPrize, Integer> winningStats = calculateWinningStats(lottoes, winningLottoes);

        Money sum = new Money();
        for (Map.Entry<WinningPrize, Integer> winningStat : winningStats.entrySet()) {
            sum = sum.add(winningStat.getKey().getPrizeMoney().multiplication(winningStat.getValue()));
        }
        double earningRate = sum.calculateRate(buyAmount);

        return new Statistics(winningStats, earningRate);
    }

    private Map<WinningPrize, Integer> calculateWinningStats(List<List<Lotto>> lottoes, List<Lotto> winningLottoes) {
        Map<WinningPrize, Integer> winningStats = new HashMap<>();
        winningStats.put(WinningPrize.THREE, 0);
        winningStats.put(WinningPrize.FOUR, 0);
        winningStats.put(WinningPrize.FIVE, 0);
        winningStats.put(WinningPrize.SIX, 0);

        for (List<Lotto> lottoList : lottoes) {
            int count = matchingWinningLotto(winningLottoes, lottoList);
            WinningPrize.findWinningPrize(count)
                    .ifPresent(winningPrize -> {
                        winningStats.put(winningPrize, winningStats.get(winningPrize) + 1);
                    });
        }
        return winningStats;
    }

    private int matchingWinningLotto(List<Lotto> winningLottoes, List<Lotto> lottoList) {
        int count = 0;
        for (Lotto lotto : lottoList) {
            count = isWinningLottoesHaveLotto(winningLottoes, count, lotto);
        }
        return count;
    }

    private int isWinningLottoesHaveLotto(List<Lotto> winningLottoes, int count, Lotto lotto) {
        if (winningLottoes.contains(lotto)) {
            count += 1;
        }
        return count;
    }
}
