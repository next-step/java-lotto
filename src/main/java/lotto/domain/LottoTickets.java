package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets create(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.from(LottoNumberGenerator.generate()));
        }
        return new LottoTickets(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public WinningResult matchWith(WinningNumbers winningNumbers){
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
