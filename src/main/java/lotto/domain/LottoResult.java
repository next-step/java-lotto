package lotto.domain;

import java.util.Map;

import javax.swing.plaf.IconUIResource;

public class LottoResult {

    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private Map<Integer, Integer> lottoResultMap;

    public LottoResult(Map<Integer, Integer> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
    }

    public LottoResult(LottoTicket lottoTicket, LottoNumbers winningNumbers) {
        this(lottoTicket.match(winningNumbers));
    }

    public float calculateRateOfReturn(int totalPriceToBuyLotto) {
        return (float) totalPrizeAmount() / (float) totalPriceToBuyLotto;
    }

    private int totalPrizeAmount() {
        int totalPrize = 0;
        for (int i = 0; i <= LOTTO_NUMBERS_LENGTH; i++) {
            totalPrize += PrizeAmount.calculate(i, lottoResultMap.getOrDefault(i, 0));
        }
        return totalPrize;
    }

    public int duplicateCount(int duplicateKey) {
        return lottoResultMap.get(duplicateKey);
    }
}
