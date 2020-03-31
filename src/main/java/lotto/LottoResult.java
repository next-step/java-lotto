package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private LottoNumbers winnerNumber;
    private Lotto lotto;

    public LottoResult(LottoNumbers winnerNumber, Lotto lotto) {
        this.winnerNumber = winnerNumber;
        this.lotto = lotto;
    }

    public Map<Integer, LottoNumbers> checkWinnerLotto() {
        Map<Integer, LottoNumbers> result = new HashMap<>();

        for (LottoNumbers lottoNumbers : lotto.getGeneratedLottos()) {
            int matchCount = extractLottoNumbers(lottoNumbers);
            result.put(matchCount, lottoNumbers);
        }
        return result;
    }

    private int extractLottoNumbers(LottoNumbers lottoNumbers) {
        int matchCount = 0;
        for (int lottoNumber : lottoNumbers.getLottoNumbers()) {
            matchCount = getMatchCount(matchCount, lottoNumber);
        }
        return matchCount;
    }

    private int getMatchCount(int matchCount, int lottoNumber) {
        if (winnerNumber.getLottoNumbers().contains(lottoNumber)) {
            ++matchCount;
        }
        return matchCount;
    }

}
