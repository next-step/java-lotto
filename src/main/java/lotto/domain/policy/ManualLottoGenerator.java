package lotto.domain.policy;

import java.util.ArrayDeque;
import java.util.Deque;
import lotto.domain.Lotto;

public class ManualLottoGenerator implements LottoPolicy {

    private final Deque<String> manualLotto;

    public ManualLottoGenerator(Deque<String> manualLotto) {
        this.manualLotto = new ArrayDeque<>(manualLotto);
    }

    @Override
    public Lotto ball() {
        if (manualLotto.isEmpty()) {
            throw new IllegalStateException("수동으로 입력한 로또가 존재하지 않습니다.");
        }
        return new Lotto(manualLotto.poll());
    }
}
