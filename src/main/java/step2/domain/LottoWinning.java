package step2.domain;

import step2.constant.LottoWinningPrizes;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static step2.constant.LottoWinningPrizes.values;

public class LottoWinning {

    private static final int LOTTO_NUMBER_CONTAINS_TRUE = 1;
    private static final int LOTTO_NUMBER_CONTAINS_FALSE = 0;
    private static final EnumMap<LottoWinningPrizes, Integer> lottoWinningMap;

    static {
        EnumMap<LottoWinningPrizes, Integer> map = new EnumMap<>(LottoWinningPrizes.class);
        Arrays.stream(values())
                .forEach(lottoWinningPrizes -> map.put(lottoWinningPrizes, 0));
        lottoWinningMap = map;
    }

    public LottoWinning(String lastLottoWinningNumbers, List<Lotto> lottos) {
        lottoWinningPrizes(lastLottoWinningNumbers, lottos);
    }

    public static LottoWinning of(String lastLottoWinningNumbers, List<Lotto> lottos) {
        return new LottoWinning(lastLottoWinningNumbers, lottos);
    }

    private static void lottoWinningPrizes(String lastLottoWinningNumbers, List<Lotto> lottos) {
        lottos.forEach(lotto -> lottoWinningPrizes(lastLottoWinningNumbers, lotto));
    }

    private static void lottoWinningPrizes(String lastLottoWinningNumbers, Lotto lotto) {
        int rightNumberCount = lotto.getLottos()
                .stream()
                .mapToInt(number -> numberContain(number, lastLottoWinningNumbers))
                .sum();
        LottoWinningPrizes.resultLottoWinning(rightNumberCount);
        setLottoWinning(rightNumberCount);

    }

    private static int numberContain(int number, String lastLottoWinningNumbers) {
        if (lastLottoWinningNumbers.contains(String.valueOf(number))) {
            return LOTTO_NUMBER_CONTAINS_TRUE;
        }
        return LOTTO_NUMBER_CONTAINS_FALSE;
    }

    public double getWinningAmount() {
        return LottoWinningPrizes.getWinningAmount();
    }

    public EnumMap<LottoWinningPrizes, Integer> getLottoWinningMap() {
        return lottoWinningMap;
    }

    private static void setLottoWinning(int rightNumberCount) {
        Arrays.stream(values())
                .filter(winningPrizes -> winningPrizes.getMatch() == rightNumberCount)
                .forEach(LottoWinning::setLottoWinning);
    }

    private static void setLottoWinning(LottoWinningPrizes winningPrizes) {
        if (lottoWinningMap.containsKey(winningPrizes)) {
            Integer value = lottoWinningMap.get(winningPrizes);
            lottoWinningMap.put(winningPrizes, ++value);
        }
    }

    public double getTotalYield(int lottoAmount) {
        double totalYield = (double) LottoWinningPrizes.getWinningAmount() / lottoAmount;
        return Double.parseDouble(String.format("%.2f", totalYield));
    }
}
