package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class LottoGame {
    public static final int BONUS_VERIFY_MATCHES = 5;

    public static Map<LottoRank, Long> getGameResult(List<Lotto> purchasedLotto, WinningLotto winningLotto) {
        List<LottoRank> result = new ArrayList<>();

        for (Lotto lotto: purchasedLotto) {
            int matches = winningLotto.compareLotto(lotto);
            result.add(LottoRank.getLottoRank(matches, matches == BONUS_VERIFY_MATCHES ? winningLotto.isBonusIncluded(lotto) : false));
        }

        return result.stream().collect(groupingBy(r -> r, counting()));
    }
}
