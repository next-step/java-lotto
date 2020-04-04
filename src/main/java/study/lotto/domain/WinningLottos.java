package study.lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningLottos {
    private EnumMap<LottoRank, Lottos> winningLottos;

    public WinningLottos() {
        initWinningLottos();
    }

    public WinningLottos(Map<LottoRank, List<Lotto>> winningLottos) {
        initWinningLottos();

        for (Map.Entry<LottoRank, List<Lotto>> entry : winningLottos
                .entrySet()) {
            addToRank(entry.getKey(), entry.getValue());
        }
    }

    protected void addToRank(LottoRank lottoRank, List<Lotto> lottos) {
        winningLottos.get(lottoRank).addAll(lottos);
    }

    public Lottos get(LottoRank lottoRank) {
        return new Lottos(winningLottos.get(lottoRank));
    }

    public int size(LottoRank lottoRank) {
        return winningLottos.get(lottoRank).size();
    }

    private void initWinningLottos() {
        winningLottos = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            winningLottos.put(lottoRank, new Lottos());
        }
    }
}
