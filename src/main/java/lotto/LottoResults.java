package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoResults {
    private final LottoRankCounter lottoRankCounter;

    private final float incomeRate;

    public LottoResults(String lotteryNumbersString, List<Lotto> lottos) {
        this.lottoRankCounter = createRankCounter(lotteryNumbersString, lottos);
        this.incomeRate = computeIncomeRate(lottos.size());
    }

    public float getIncomeRate() {
        return incomeRate;
    }

    public int totalCountOfMatch(LottoRank rank) {
        return lottoRankCounter.getCount(rank);
    }

    private LottoRankCounter createRankCounter(String lotteryNumbersString, List<Lotto> lottos) {
        LottoRankCounter rankCounter = new LottoRankCounter();

        List<Integer> lotteryNumbers = createLotteryNumbers(lotteryNumbersString);

        lottos.stream()
                .mapToInt(lotto -> lotto.computeCountOfMatch(lotteryNumbers))
                .filter(countOfMatch -> countOfMatch > 0)
                .mapToObj(LottoRank::valueOf)
                .forEach(rankCounter::addCount);

        return rankCounter;
    }

    private List<Integer> createLotteryNumbers(String lotteryNumbersString) {
        String[] lotteryNumberStrings = lotteryNumbersString.split(",");
        return Arrays.stream(lotteryNumberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private float computeIncomeRate(int countOfLotto) {
        float allLottoTotalMoney = IntStream.range(0,6)
                                          .mapToObj(LottoRank::valueOf)
                                          .mapToInt(this::getTotalLottoMoneyOf)
                                          .sum();

        float purchaseAmounts = LottoFactory.SINGLE_LOTTO_MONEY * countOfLotto;
        float rawIncomeRate = allLottoTotalMoney / purchaseAmounts;
        return changeDecimalTwoPoint(rawIncomeRate);
    }

    private float changeDecimalTwoPoint(float value) {
        String stringValue = String.format("%.02f", value);
        return Float.parseFloat(stringValue);
    }

    private int getTotalLottoMoneyOf(LottoRank rank) {
        return this.lottoRankCounter.getTotalLottoMoney(rank);
    }
}
