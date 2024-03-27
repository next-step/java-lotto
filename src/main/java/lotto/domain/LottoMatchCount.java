package lotto.domain;

import java.util.List;

public class LottoMatchCount {
    private static final int MATCH_COUNT_STANDARD = 3;

    public static int matchCount(List<LottoNumber> lottoNumbers, List<Integer> winNumbers) {
        int count = 0;

        for (LottoNumber lottoNumber : lottoNumbers)
            count += isEqualLottoAndWin(winNumbers, lottoNumber);

        if (count < MATCH_COUNT_STANDARD) {
            return 0;
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
