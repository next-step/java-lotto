package lotto.domain;

import java.util.List;

public class LottoMatchCount {

    public static int matchCount(List<LottoNumber> lottoNumbers, List<Integer> winNumbers) {
        int count = 0;

        for (int i = 0; i < winNumbers.size(); i++) {
            count += isEqualLottoAndWin(winNumbers, lottoNumbers.get(i));
        }

        return count;
    }

    private static int isEqualLottoAndWin(List<Integer> winNumbers, LottoNumber lottoNumber) {
        if (winNumbers.contains(lottoNumber.getLottoNumber())) {
            return 1;
        }
        return 0;
    }
}
