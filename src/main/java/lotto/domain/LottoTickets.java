package lotto.domain;

import java.util.ArrayList;
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

    public static LottoTickets create(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.from(LottoNumberGenerator.generate()));
        }
        return new LottoTickets(lottos);
    }

    public static LottoTickets create(PurchaseAmount purchaseAmount, ManualLottos manualLottos) {
        validateManualLottoCount(purchaseAmount, manualLottos);
        List<Lotto> lottos = createLottos(purchaseAmount, manualLottos);
        return new LottoTickets(lottos, manualLottos);
    }

    private static void validateManualLottoCount(PurchaseAmount purchaseAmount, ManualLottos manualLottos) {
        if (manualLottos.getCount() > purchaseAmount.getLottoCount()) {
            throw new IllegalArgumentException("수동로또 개수가 구입 가능한 개수보다 많습니다.");
        }
    }

    private static List<Lotto> createLottos(PurchaseAmount purchaseAmount, ManualLottos manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos.getManualLottos());
        int autoCount = purchaseAmount.getLottoCount() - manualLottos.getCount();
        for (int i = 0; i < autoCount; i++) {
            lottos.add(Lotto.from(LottoNumberGenerator.generate()));
        }
        return lottos;
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
        return new ArrayList<>(lottos);
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
