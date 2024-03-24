package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMatch {

    public static int match(List<LottoNumber> lottoNumbers, List<Integer> winNumbers) {
        int count = 0;

        for (int i = 0; i < winNumbers.size(); i++) {
            count += isEqaulLottoAndWin(winNumbers.get(i), lottoNumbers.get(i));
        }

        return count;
    }

    private static int isEqaulLottoAndWin(int winNumber, LottoNumber lottoNumber) {
        if (new LottoNumber(winNumber).equals(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
