package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    public static final int MINIMUM_REWARD_MATCH = 3;
    public static final int MAXIMUM_REWARD_MATCH = 6;

    public static Map<Integer, Integer> getGameResult(List<Lotto> purchasedLotto, WinningLotto winningLotto) {
        Map<Integer, Integer> gameResult = new HashMap<>();

        for (int i = MINIMUM_REWARD_MATCH; i <= MAXIMUM_REWARD_MATCH; i ++) {
            gameResult.put(i, 0);
        }

        for (Lotto lotto: purchasedLotto) {
            int result = winningLotto.compareLotto(lotto);

            try {
                gameResult.put(result, gameResult.get(result) + 1);
            } catch (NullPointerException ignored) {}
        }

        return gameResult;
    }
}
