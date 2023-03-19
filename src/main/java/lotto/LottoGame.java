package lotto;

import java.util.List;

public class LottoGame {
    public static Rank match(List<LottoNumber> userLotto,
                            List<LottoNumber> winningLotto,
                            LottoNumber bonusNumber) {
        int matchCount = match(userLotto, winningLotto);
        boolean bonusMatch = userLotto.contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    public static int match(List<LottoNumber> userLotto,
                            List<LottoNumber> winningLotto) {
        return (int) userLotto.stream()
                .filter(it -> winningLotto.contains(it))
                .count();
    }


}
