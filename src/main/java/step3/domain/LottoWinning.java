package step3.domain;

import step3.constant.LottoWinningPrizes;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static step3.constant.LottoWinningPrizes.values;

public class LottoWinning {

    private static final int LOTTO_NUMBER_CONTAINS_TRUE = 1;
    private static final int LOTTO_NUMBER_CONTAINS_FALSE = 0;
    private static final EnumMap<LottoWinningPrizes, Integer> lottoWinningMap;

    private long winningAmount = 0;

    static {
        EnumMap<LottoWinningPrizes, Integer> map = new EnumMap<>(LottoWinningPrizes.class);
        Arrays.stream(values())
                .forEach(lottoWinningPrizes -> map.put(lottoWinningPrizes, 0));
        lottoWinningMap = map;
    }

    public LottoWinning(LottoNumber lottoNumber, List<Lotto> lottos) {
        lottoWinningPrizes(lottoNumber, lottos);
    }

    public static LottoWinning of(LottoNumber lottoNumber, List<Lotto> lottos) {
        return new LottoWinning(lottoNumber, lottos);
    }

    private void lottoWinningPrizes(LottoNumber lastLottoWinningNumbers, List<Lotto> lottos) {
        lottos.forEach(lotto -> lottoWinningPrizes(lastLottoWinningNumbers, lotto));
    }

    private void lottoWinningPrizes(LottoNumber lottoNumber, Lotto lotto) {
        int rightNumberCount = lotto.getLottos()
                .stream()
                .mapToInt(number -> numberContain(number, lottoNumber.getLastWeekNumber()))
                .sum();

        boolean isMatchBonus = isMatchBonus(lottoNumber.getBonusNumber(), lotto);
        this.winningAmount += LottoWinningPrizes.findLottoMatch(rightNumberCount, isMatchBonus).getAmount();
        setLottoWinning(LottoWinningPrizes.findLottoMatch(rightNumberCount, isMatchBonus));

    }

    private boolean isMatchBonus(String bonusNumber, Lotto lotto) {
        return lotto.getLottos()
                .stream()
                .anyMatch(bonus -> bonusNumber.contains(String.valueOf(bonus)));
    }

    private int numberContain(int number, String lastLottoWinningNumbers) {
        if (lastLottoWinningNumbers.contains(String.valueOf(number))) {
            return LOTTO_NUMBER_CONTAINS_TRUE;
        }
        return LOTTO_NUMBER_CONTAINS_FALSE;
    }

    public EnumMap<LottoWinningPrizes, Integer> getLottoWinningMap() {
        return lottoWinningMap;
    }

    private void setLottoWinning(LottoWinningPrizes winningPrizes) {
        if (lottoWinningMap.containsKey(winningPrizes)) {
            Integer value = lottoWinningMap.get(winningPrizes);
            lottoWinningMap.put(winningPrizes, ++value);
        }
    }

    public double getTotalYield(int lottoAmount) {
        double totalYield = (double) getWinningAmount() / lottoAmount;
        return Double.parseDouble(String.format("%.2f", totalYield));
    }

    public long getWinningAmount() {
        return this.winningAmount;
    }
}
