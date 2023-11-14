package step3.domain;

import step2.domain.LottoMachine;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;

public class ResultProcessor {

    private static final int PRICE_PER_LOTTO = LottoMachine.PRICE_PER_LOTTO;

    public WinningResult result(WinningNumbers winningNumbers, Lottos lottos) {

        LinkedHashMap<LottoRank, Integer> result = new LinkedHashMap<>();
        for(Lotto lotto: lottos.lottos()){
            int matchCount = winningNumbers.matchCount(lotto);
            boolean matchBonus = winningNumbers.containBonus(lotto);
            LottoRank lottoRank = LottoRank.valueOf(matchCount, matchBonus);
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1);
        }

        return new WinningResult(result, earningRate(result, lottos));
    }

    private static String earningRate(LinkedHashMap<LottoRank, Integer> result, Lottos lottos) {
        DecimalFormat df = new DecimalFormat("0.00");
        int earningRate = totalEarningMoney(result) / totalPurchasePrice(lottos);
        return df.format(earningRate);

    }

    private static int totalPurchasePrice(Lottos lottos) {
        return lottos.lottos().size() * PRICE_PER_LOTTO;
    }

    private static int totalEarningMoney(LinkedHashMap<LottoRank, Integer> result) {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().winningMoney() * entry.getValue())
                .sum();
    }
}
