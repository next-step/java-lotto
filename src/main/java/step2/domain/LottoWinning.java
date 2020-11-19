package step2.domain;

import step2.constant.LottoWinningPrizes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static step2.constant.LottoWinningPrizes.*;

public class LottoWinning {

    private static HashMap<LottoWinningPrizes, Integer> lottoWinningMap = new LinkedHashMap<>();
    private static int winningAmount = 0;

    public LottoWinning(String lastLottoWinningNumbers, List<Lotto> lottos) {
        setLottoWinningMap();
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
        resultLottoWinning(rightNumberCount);
    }

    private static int numberContain(int number, String lastLottoWinningNumbers) {
        if (lastLottoWinningNumbers.contains(String.valueOf(number))) {
            return 1;
        }
        return 0;
    }

    private static void resultLottoWinning(int rightNumberCount) {
        for (LottoWinningPrizes lottoWinningPrizes : values()) {
            if (lottoWinningPrizes.getMatch() == rightNumberCount) {
                winningAmount += lottoWinningPrizes.getAmount();
            }
        }
        setLottoWinning(rightNumberCount);
    }

    public double getWinningAmount() {
        return winningAmount;
    }

    public HashMap<LottoWinningPrizes, Integer> getLottoWinningMap() {
        return lottoWinningMap;
    }

    private static void setLottoWinning(int rightNumberCount) {
        if (THIRD_MATCHES.getMatch() == rightNumberCount) {
            lottoWinningMap.put(THIRD_MATCHES, lottoWinningMap.get(THIRD_MATCHES) + 1);
        }
        if (FOUR_MATCHES.getMatch() == rightNumberCount) {
            lottoWinningMap.put(FOUR_MATCHES, lottoWinningMap.get(FOUR_MATCHES) + 1);
        }
        if (FIVE_MATCHES.getMatch() == rightNumberCount) {
            lottoWinningMap.put(FIVE_MATCHES, lottoWinningMap.get(FIVE_MATCHES) + 1);
        }
        if (SIX_MATCHES.getMatch() == rightNumberCount) {
            lottoWinningMap.put(SIX_MATCHES, lottoWinningMap.get(SIX_MATCHES) + 1);
        }
    }

    private static void setLottoWinningMap() {
        lottoWinningMap.put(THIRD_MATCHES, 0);
        lottoWinningMap.put(FOUR_MATCHES, 0);
        lottoWinningMap.put(FIVE_MATCHES, 0);
        lottoWinningMap.put(SIX_MATCHES, 0);
    }
}
