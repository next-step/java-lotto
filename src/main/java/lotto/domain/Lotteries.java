package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotteries {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lottery> lotteries;

    public static Lotteries purchase(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 1000 이상이어야 합니다");
        }

        int lottoCount = purchaseAmount / LOTTO_PRICE;
        return generateLottoNumbersList(lottoCount);
    }

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public int size() {
        return lotteries.size();
    }

    public List<Integer> getWinningNumberCountList(Lottery winningLottery) {
        return lotteries.stream()
                .map(lottery -> lottery.countWinningNumbers(winningLottery))
                .collect(Collectors.toList());
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    private static Lotteries generateLottoNumbersList(int lottoCount) {
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();
        List<Lottery> lotteries = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> generatedNumbers = lottoNumberGenerator.generateNumbers();
            lotteries.add(new Lottery(generatedNumbers));
        }

        return new Lotteries(lotteries);
    }
}
