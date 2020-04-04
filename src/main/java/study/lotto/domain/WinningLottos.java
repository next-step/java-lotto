package study.lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningLottos {
    private EnumMap<LottoRank, Lottos> lottoRanks;

    public WinningLottos() {
        initWinningLottos();
    }

    public WinningLottos(Map<LottoRank, List<Lotto>> lottoRanks) {
        initWinningLottos();

        for (Map.Entry<LottoRank, List<Lotto>> entry : lottoRanks
                .entrySet()) {
            addToRank(entry.getKey(), entry.getValue());
        }
    }

    protected void addToRank(LottoRank lottoRank, List<Lotto> lottos) {
        lottoRanks.get(lottoRank).addAll(lottos);
    }

    public Lottos get(LottoRank lottoRank) {
        return new Lottos(lottoRanks.get(lottoRank));
    }

    public int size(LottoRank lottoRank) {
        return lottoRanks.get(lottoRank).size();
    }

    private void initWinningLottos() {
        lottoRanks = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoRanks.put(lottoRank, new Lottos());
        }
    }
}
