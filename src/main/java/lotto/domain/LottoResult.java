package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private Map<Integer, Integer> lottoResultMap;

    public LottoResult(LottoTicket lottoTicket, LottoNumbers winningNumbers) {
        initializeLottoResultMap();
        countResults(lottoTicket, winningNumbers);
    }

    private void initializeLottoResultMap() {
        lottoResultMap = new HashMap<>();
        for (int i = 0; i <= LOTTO_NUMBERS_LENGTH; i++) {
            lottoResultMap.put(i, 0);
        }
    }

    private void countResults(LottoTicket lottoTicket, LottoNumbers winningNumbers) {
        List<LottoNumbers> allLottoNumbers = lottoTicket.allLottoNumbers();
        for (int i = 0; i < allLottoNumbers.size(); i++) {
            int duplicateNumberCount = allLottoNumbers.get(i).countDuplicateNumber(winningNumbers);
            lottoResultMap.replace(duplicateNumberCount, lottoResultMap.get(duplicateNumberCount) + 1);
        }
    }

    public float calculateRateOfReturn(int totalPriceToBuyLotto) {
        return (float) totalPrizeAmount() / (float) totalPriceToBuyLotto;
    }

    private int totalPrizeAmount() {
        int totalPrize = 0;
        for (int i = 0; i <= LOTTO_NUMBERS_LENGTH; i++) {
            totalPrize += PrizeAmount.calculate(i, lottoResultMap.get(i));
        }
        return totalPrize;
    }

    public int duplicateCount(int duplicateKey) {
        return lottoResultMap.get(duplicateKey);
    }
}
