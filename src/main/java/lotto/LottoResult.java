package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private LottoNumbers winnerNumber;
    private Lotto lotto;

    public LottoResult(LottoNumbers winnerNumber, Lotto lotto) {
        this.winnerNumber = winnerNumber;
        this.lotto = lotto;
    }

    public Map<Integer, List<LottoNumbers>> checkWinnerLotto() {
        List<LottoNumbers> result = new ArrayList<>();

        for (LottoNumbers userLotto : lotto.getGeneratedLottos()) {
            int matchCount = extractLottoNumbers(userLotto);

        }
        return null;
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
