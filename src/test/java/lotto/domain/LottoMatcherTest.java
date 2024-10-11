package lotto.domain;

import java.util.List;

public class LottoMatcher {

    public static int match(List<Integer> lastWinningNumbers, List<Integer> userNumbers) {
        int count = 0;
        for (Integer lottoNumber : lastWinningNumbers) {
            if (userNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return 0;
    }
}
