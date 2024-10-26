package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotteries {

    private final List<Lottery> lotteries;

    private Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public Lotteries(List<Lottery> manualLotteries, int lottoCount) {
        this(mergeLotteries(manualLotteries, generateAutoLotteries(lottoCount)));
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
            ranks.add(winningLottery.createLottoRank(lottery));
        }

        return ranks;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    private static List<Lottery> mergeLotteries(List<Lottery> manualLotteries, List<Lottery> autoLotteries) {
        List<Lottery> lotteries = new ArrayList<>();
        lotteries.addAll(manualLotteries);
        lotteries.addAll(autoLotteries);

        return lotteries;
    }

    private static List<Lottery> generateAutoLotteries(int lottoCount) {
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();
        List<Lottery> lotteries = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> generatedNumbers = lottoNumberGenerator.generateNumbers();
            lotteries.add(new Lottery(generatedNumbers));
        }

        return lotteries;
    }
}
