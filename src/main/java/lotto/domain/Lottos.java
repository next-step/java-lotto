package lotto.domain;

import java.util.*;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();
    private final Map<WinType, Integer> winResults = new EnumMap<>(WinType.class);
    private static final int ZERO = 0;

    public Lottos() {
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos generateAutoLottos(int buyCnt) {
        for (int i = 0; i < buyCnt; i++) {
            Lotto lotto = new Lotto(AutoLottoNumberPool.getLottoNumbers());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public Lottos generateManualLottos(List<Lotto> manualLottos) {
        return new Lottos(manualLottos);
    }

    public Map<WinType, Integer> matchWinning(WinningLotto winningLotto) {

        initializeWinResults();

        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.matchNumberCnt(lotto);
            boolean matchBonus = winningLotto.matchBonus(lotto);
            int existsWinCount = getWinCount(matchCount, matchBonus);
            winResults.put(WinType.valueOf(matchCount, matchBonus), existsWinCount + 1);
        }

        return winResults;
    }

    public int size() {
        return lottos.size();
    }

    public Lottos conbine(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
        return new Lottos(this.lottos);
    }

    private int getWinCount(int matchCnt, boolean matchBonus) {
        Integer winCount = winResults.get(WinType.valueOf(matchCnt, matchBonus));

        if (winCount == null) {
            return ZERO;
        }
        return winCount;
    }

    private void initializeWinResults() {
        Arrays.stream(WinType.values())
                .forEach(it -> winResults.put(it, ZERO));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
