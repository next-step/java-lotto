package step3.domain;

import step3.constant.LottoWinningPrizes;

import java.util.Arrays;
import java.util.EnumMap;

import static step3.constant.LottoWinningPrizes.values;

public class LottoWinning {

    private static final EnumMap<LottoWinningPrizes, Integer> lottoWinningMap;

    private long winningAmount = 0;

    static {
        EnumMap<LottoWinningPrizes, Integer> map = new EnumMap<>(LottoWinningPrizes.class);
        Arrays.stream(values())
                .forEach(lottoWinningPrizes -> map.put(lottoWinningPrizes, 0));
        lottoWinningMap = map;
    }

    public LottoWinning(LottoNumber lottoNumber, Lottos lottos) {
        lottoWinningPrizes(lottoNumber, lottos);
    }

    public static LottoWinning of(LottoNumber lottoNumber, Lottos lottos) {
        return new LottoWinning(lottoNumber, lottos);
    }

    private void lottoWinningPrizes(LottoNumber lastLottoWinningNumbers, Lottos lottos) {
        lottos.getLottos().forEach(lotto -> {
            int rightNumberCount = lottos.lottoWinningPrizes(lastLottoWinningNumbers, lotto);
            boolean isMatchBonus = isMatchBonus(lastLottoWinningNumbers.getBonusNumber(), lotto);
            lottoWinningPrizes(rightNumberCount, isMatchBonus);
        });
    }

    private void lottoWinningPrizes(int rightNumberCount, boolean isMatchBonus) {
        this.winningAmount += LottoWinningPrizes.findLottoMatch(rightNumberCount, isMatchBonus).getAmount();
        setLottoWinning(LottoWinningPrizes.findLottoMatch(rightNumberCount, isMatchBonus));
    }

    private boolean isMatchBonus(String bonusNumber, Lotto lotto) {
        return lotto.getLottos()
                .stream()
                .anyMatch(bonus -> bonusNumber.contains(String.valueOf(bonus)));
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
