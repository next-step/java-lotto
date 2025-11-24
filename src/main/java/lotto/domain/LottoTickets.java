package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<Lotto> lottos;
    private final ManualLottos manualLottos;

    public LottoTickets(List<Lotto> lottos) {
        this(lottos, new ManualLottos(lottos));
    }

    public LottoTickets(List<Lotto> lottos, ManualLottos manualLottos) {
        this.lottos = lottos;
        this.manualLottos = manualLottos;
    }

    public int getManualCount() {
        return manualLottos.getCount();
    }

    public int getAutoCount() {
        return lottos.size() - manualLottos.getCount();
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public WinningResult matchWith(WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = initializeResult();
        for (Lotto lotto : lottos) {
            Rank rank = winningNumbers.match(lotto);
            result.put(rank, result.get(rank) + 1);
        }
        return new WinningResult(result);
    }

    private Map<Rank, Integer> initializeResult() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
