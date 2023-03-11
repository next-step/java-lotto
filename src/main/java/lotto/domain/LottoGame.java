package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoGame {
    private static final int PRICE = 1000;

    private final List<Lotto> lottos;
    private final int count;
    private final LotteryStatistics lotteryStatistics;

    public LottoGame(int lottoPay) {
        this.count = lottoPay / PRICE;
        this.lotteryStatistics = new LotteryStatistics();
        this.lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
        this.lotteryStatistics = new LotteryStatistics();
        this.count = lottos.size() * PRICE;
    }

    public int getBuyPrice() {
        return count * PRICE;
    }

    public String getAllLottoNumbers() {
        StringBuilder allLottoNumbers = new StringBuilder();
        lottos.forEach(lotto -> allLottoNumbers.append(lotto.getLottoNumbersForPrint()).append("\n"));
        return allLottoNumbers.toString();
    }

    public LotteryStatistics getStatistics(WinningNumbers winningNumbers) {

        lottos.stream()
                .map(lotto -> {
                    HashSet<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());
                    return winningNumbers.getWinningGrade(lottoNumbers);
                })
                .forEach(this.lotteryStatistics::add);

        return this.lotteryStatistics;
    }
}
