package lotto;

import java.util.*;

public class LottoAutoCalculateStrategy implements LottoCalculateStrategy {
    private static final Money LOTTO_TICKET_PRICE = new Money(1000);
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int WINNING_LOTTO_COUNT = 6;
    private static final List<LottoNumber> lottoCandidates = new ArrayList<>();

    static {
        for (int i = 0; i < MAX_LOTTO_NUMBER; i++) {
            lottoCandidates.add(new LottoNumber(i + 1));
        }
    }

    @Override
    public int calculateLottoTicketCount(Money money) {
        return money.countBy(LOTTO_TICKET_PRICE);
    }

    @Override
    public List<List<LottoNumber>> buyLottoes(int ticketCount) {
        List<List<LottoNumber>> lottoes = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Collections.shuffle(lottoCandidates);
            List<LottoNumber> lottos = new ArrayList<>(lottoCandidates.subList(0, WINNING_LOTTO_COUNT));
            lottos.sort(Comparator.comparing(LottoNumber::getNumber));
            lottoes.add(lottos);
        }
        return lottoes;
    }

    @Override
    public Statistics calculateStatistics(List<List<LottoNumber>> lottoes, List<LottoNumber> winningLottoes, Money buyAmount) {
        Map<WinningPrize, Integer> winningStats = calculateWinningStats(lottoes, winningLottoes);

        Money sum = new Money();
        for (Map.Entry<WinningPrize, Integer> winningStat : winningStats.entrySet()) {
            sum = sum.add(winningStat.getKey().getPrizeMoney().multiplication(winningStat.getValue()));
        }
        double earningRate = sum.calculateRate(buyAmount);

        return new Statistics(winningStats, earningRate);
    }

    private Map<WinningPrize, Integer> calculateWinningStats(List<List<LottoNumber>> lottoes, List<LottoNumber> winningLottoes) {
        Map<WinningPrize, Integer> winningStats = new HashMap<>();
        winningStats.put(WinningPrize.THREE, 0);
        winningStats.put(WinningPrize.FOUR, 0);
        winningStats.put(WinningPrize.FIVE, 0);
        winningStats.put(WinningPrize.SIX, 0);

        for (List<LottoNumber> lottoList : lottoes) {
            int count = matchingWinningLotto(winningLottoes, lottoList);
            WinningPrize.findWinningPrize(count)
                    .ifPresent(winningPrize -> {
                        winningStats.put(winningPrize, winningStats.get(winningPrize) + 1);
                    });
        }
        return winningStats;
    }

    private int matchingWinningLotto(List<LottoNumber> winningLottoes, List<LottoNumber> lottoList) {
        int count = 0;
        for (LottoNumber lotto : lottoList) {
            count = isWinningLottoesHaveLotto(winningLottoes, count, lotto);
        }
        return count;
    }

    private int isWinningLottoesHaveLotto(List<LottoNumber> winningLottoes, int count, LottoNumber lotto) {
        if (winningLottoes.contains(lotto)) {
            count += 1;
        }
        return count;
    }
}
