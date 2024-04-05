package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class LottoGame {
    public static final int MINIMUM_REWARD_MATCH = 3;
    public static final int MAXIMUM_REWARD_MATCH = 6;
    public static final int BONUS_VERIFY_MATCHES = 5;

    public static Map<LottoRank, Long> getGameResult(List<Lotto> purchasedLotto, WinningLotto winningLotto) {
        List<LottoRank> result = new ArrayList<>();
        for (Lotto lotto: purchasedLotto) {
            Integer matches = winningLotto.compareLotto(lotto);

            if (matches == BONUS_VERIFY_MATCHES) {
                result.add(LottoRank.getLottoRank(matches, winningLotto.isBonusIncluded(lotto)));
            }

            result.add(LottoRank.getLottoRank(matches));
        }

        return result.stream().collect(groupingBy(r -> r, counting()));
    }

}
