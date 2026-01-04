package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoNumberGenerator generator;

    public LottoMachine(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public Lottos issue(Money money) {
        return issue(money, 0, List.of());
    }

    public Lottos issue(Money money, int manualCount, List<Lotto> manualLottos) {
        validateManualCount(money, manualCount, manualLottos);

        List<Lotto> issued = new ArrayList<>();
        issued.addAll(manualLottos);

        int autoCount = money.ticketCount() - manualCount;
        for (int i = 0; i < autoCount; i++) {
            issued.add(new Lotto(generator.generate()));
        }
        return new Lottos(issued);
    }

    private void validateManualCount(Money money, int manualCount, List<Lotto> manualLottos) {
        if (manualCount < 0) {
            throw new IllegalArgumentException("수동 구매 수는 0 이상이어야 합니다.");
        }
        if (manualCount > money.ticketCount()) {
            throw new IllegalArgumentException("수동 구매 수는 전체 구매 수보다 클 수 없습니다.");
        }
        if (manualLottos.size() != manualCount) {
            throw new IllegalArgumentException("수동 로또 장 수가 수동 구매 수와 일치해야 합니다.");
        }
    }
}
