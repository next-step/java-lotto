package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class LottoGame {
    public static final int MINIMUM_REWARD_MATCH = 3;
    public static final int MAXIMUM_REWARD_MATCH = 6;

    public static Map<LottoRank, Long> getGameResult(List<Lotto> purchasedLotto, WinningLotto winningLotto) {
        List<Integer> result = new ArrayList<>();
        for (Lotto lotto: purchasedLotto) {
            result.add(winningLotto.compareLotto(lotto));
        }

        return result.stream().collect(groupingByConcurrent(LottoRank::getLottoRank, counting()));
    }
}
