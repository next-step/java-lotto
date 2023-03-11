package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoGame {
    public static final int PRICE = 1000;

    private final List<Lotto> lottos;
    private final int count;
    private final WinningStatistics winningStatistics;

    public LottoGame(int lottoPay) {
        this.count = lottoPay / PRICE;
        this.winningStatistics = new WinningStatistics();
        this.lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
        this.winningStatistics = new WinningStatistics();
        this.count = lottos.size() * PRICE;
    }

    public int getBuyPrice() {
        return count * PRICE;
    }

    public String getAllLottoNumbersForPrint() {
        StringBuilder allLottoNumbers = new StringBuilder();
        lottos.forEach(lotto -> allLottoNumbers.append(lotto.getLottoNumbersForPrint()).append("\n"));
        return allLottoNumbers.toString();
    }

    public WinningStatistics getStatistics(LotteryNumbers lotteryNumbers) {

        lottos.stream()
                .map(lotto -> {
                    HashSet<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());
                    return lotteryNumbers.getWinningGrade(lottoNumbers);
                })
                .forEach(this.winningStatistics::add);

        return this.winningStatistics;
    }

    public double getTotalRateOfReturn(LotteryNumbers lotteryNumbers) {
        WinningStatistics statistics = getStatistics(lotteryNumbers);
        return statistics.getTotalRateOfReturn();
    }

    public String getBuyCountForPrint() {
        return Integer.toString(count);
    }
}
