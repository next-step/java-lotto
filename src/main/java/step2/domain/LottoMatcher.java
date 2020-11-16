package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMatcher {
    private static final int INCREASE_COUNT = 1;
    private Map<LottoRank, Integer> result = new HashMap<>();

    public LottoMatcher() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    public void increaseMatchLottoCount(int match) {
        result.put(getLottoRank(match), getLottoCount(getLottoRank(match)) + INCREASE_COUNT);
    }

    private LottoRank getLottoRank(int match) {
        return LottoRank.valueOf(match);
    }

    private int getLottoCount(LottoRank lottoRank) {
        return result.getOrDefault(lottoRank, 0);
    }


    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public GameMoney getGamePrize() {
        GameMoney gameMoney = new GameMoney(0);
        for (LottoRank lottoRank : result.keySet()) {
            gameMoney = gameMoney.sum(lottoRank.prize(result.get(lottoRank)));
        }
        return gameMoney;
    }
}
