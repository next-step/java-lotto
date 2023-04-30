package study.lotto.step2.domain;

import java.util.List;

public class LottoFactory {
    private final AutoNumberSelector autoNumberSelector;

    public LottoFactory(AutoNumberSelector autoNumberSelector) {
        this.autoNumberSelector = autoNumberSelector;
    }

    public Lotto lotto() {
        return new Lotto(selectedNumber());
    }

    private List<Integer> selectedNumber() {
        return autoNumberSelector.selectedNumber();
    }
}
