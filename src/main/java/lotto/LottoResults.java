package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoResults {
    private static final int MAX_LOTTO_FIT_COUNT = 6;

    private final int[] fitCounts;
    private final float incomeRate;

    public LottoResults(String lotteryNumbersString, List<Lotto> lottos) {
        this.fitCounts = createFitCounts(lotteryNumbersString, lottos);
        this.incomeRate = computeIncomeRate(lottos.size());
    }

    private int[] createFitCounts(String lotteryNumbersString, List<Lotto> lottos) {
        int[] fitCounts = new int[MAX_LOTTO_FIT_COUNT];

        List<Integer> lotteryNumbers = createLotteryNumbers(lotteryNumbersString);

        lottos.stream()
                .mapToInt(rotto -> rotto.computeCountOfNumberExist(lotteryNumbers))
                .filter(fitCount -> fitCount > 0)
                .forEach(fitCount -> fitCounts[fitCount - 1] += 1);

        return fitCounts;
    }

    private List<Integer> createLotteryNumbers(String lotteryNumbersString) {
        String[] lotteryNumberStrings = lotteryNumbersString.split(",");
        return Arrays.stream(lotteryNumberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private float computeIncomeRate(int countOfLotto) {
        float totalLottoAmount = IntStream.range(0,6)
                .map(this::getTotalLottoAmountOf)
                .sum();

        float purchaseAmounts = LottoFactory.SINGLE_LOTTO_AMOUNT * countOfLotto;
        float rawIncomeRate = totalLottoAmount / purchaseAmounts;
        return convertDigit2(rawIncomeRate);
    }

    private float convertDigit2(float value) {
        String stringValue = String.format("%.02f", value);
        return Float.parseFloat(stringValue);
    }

    private int getTotalLottoAmountOf(int fitIndex) {
        int lottoFitCount = fitIndex + 1;
        LottoAmount lottoAmount = LottoAmount.getByFitCount(lottoFitCount);
        int fitCount = fitCounts[fitIndex];

        return lottoAmount.getAmount() * fitCount;
    }

    public int countLotteryOf(int fitCount) {
        int index = fitCount - 1;
        return fitCounts[index];
    }

    public float getIncomeRate() {
        return incomeRate;
    }
}
