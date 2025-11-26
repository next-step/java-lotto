package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(Money money) {
        this(buyLotto(money));
    }

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    private static List<Lotto> buyLotto(Money money) {
        int cnt = money.getBuyableCount();

        List<Lotto> lottoArray = new ArrayList<>();

        for(int i = 0; i < cnt; i++) {
            lottoArray.add(new Lotto(LottoMachine.createLottoNumbers()));
        }

        return lottoArray;
    }

    public List<Lotto> getLottoNumbers() {
        return lottos;
    }

    public LottoResult match(Lotto winLotto) {
        return new LottoResult(calculate(winLotto));
    }

    private  Map<LottoRank, Integer> calculate(Lotto winLotto) {
        Map<LottoRank, Integer> reusltMap = initResult();

        for (Lotto lotto : this.lottos) {
            int cnt = lotto.matchedCount(winLotto);
            LottoRank lottoRank = LottoRank.getLottoRank(cnt);

            if (lottoRank != null) {
                reusltMap.put(lottoRank, reusltMap.get(lottoRank) + 1);
            }
        }

        return reusltMap;
    }
    private  Map<LottoRank, Integer> initResult() {
        Map<LottoRank, Integer> map = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            map.put(lottoRank, 0);
        }

        return map;
    }
}
