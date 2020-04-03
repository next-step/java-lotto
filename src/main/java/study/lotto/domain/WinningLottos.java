package study.lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningLottos {
    private EnumMap<LottoRank, Lottos> winningLottos;

    public WinningLottos() {
        initWinningLottos();
    }

    public void addToRank(LottoRank lottoRank, Lotto lotto) {
        winningLottos.get(lottoRank).add(lotto);
    }

    public Lottos get(LottoRank lottoRank) {
        return new Lottos(winningLottos.get(lottoRank));
    }

    public int size(LottoRank lottoRank) {
        return winningLottos.get(lottoRank).size();
    }

    private Map<LottoRank, Lottos> initWinningLottos() {
        winningLottos = new EnumMap(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            winningLottos.put(lottoRank, new Lottos());
        }

        return winningLottos;
    }
}
