package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotteries {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lottery> lotteries;

    public static Lotteries purchase(int totalPurchaseAmount, List<Set<Integer>> manualLottoNumbersList) {
        if (totalPurchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 1000 이상이어야 합니다");
        }

        if (LOTTO_PRICE * manualLottoNumbersList.size() > totalPurchaseAmount) {
            throw new IllegalArgumentException("수동 구매 수량의 가격이 구입금액을 초과했습니다");
        }

        int autoLottoCount = calculateAutoLottoCount(totalPurchaseAmount, manualLottoNumbersList.size());

        return new Lotteries(generateLotteries(autoLottoCount, manualLottoNumbersList));
    }

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public int size() {
        return lotteries.size();
    }

    public LottoStatistics createStatistics(WinningLottery winningLottery) {
        List<LottoRank> lottoRanks = getLottoRanks(winningLottery);
        return LottoStatistics.create(lottoRanks);
    }

    private List<LottoRank> getLottoRanks(WinningLottery winningLottery) {
        List<LottoRank> ranks = new ArrayList<>();

        for (Lottery lottery : lotteries) {
            ranks.add(lottery.createLottoRank(winningLottery));
        }

        return ranks;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    private static int calculateAutoLottoCount(int totalPurchaseAmount, int manualLottoCount) {
        int manualLottoPurchaseAmount = LOTTO_PRICE * manualLottoCount;
        return (totalPurchaseAmount - manualLottoPurchaseAmount) / LOTTO_PRICE;
    }

    private static List<Lottery> generateLotteries(int autoLottoCount, List<Set<Integer>> manualLottoNumbersList) {
        List<Lottery> lotteries = new ArrayList<>();

        lotteries.addAll(generateLottoNumbersList(autoLottoCount));
        lotteries.addAll(generateManualLotteries(manualLottoNumbersList));

        return lotteries;
    }

    private static List<Lottery> generateLottoNumbersList(int lottoCount) {
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();
        List<Lottery> lotteries = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> generatedNumbers = lottoNumberGenerator.generateNumbers();
            lotteries.add(new Lottery(generatedNumbers));
        }

        return lotteries;
    }

    private static List<Lottery> generateManualLotteries(List<Set<Integer>> lottoNumbersList) {
        List<Lottery> lotteries = new ArrayList<>();

        for (Set<Integer> lottoNumbers : lottoNumbersList) {
            lotteries.add(new Lottery(lottoNumbers));
        }

        return lotteries;
    }
}
