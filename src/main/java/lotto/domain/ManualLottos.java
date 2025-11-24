package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ManualLottos {
    private final List<String> manualLottosInput;

    public ManualLottos(List<String> manualLottosInput) {
        this.manualLottosInput = Optional.ofNullable(manualLottosInput)
                .orElse(Collections.emptyList());
    }

    public int getCount() {
        return manualLottosInput.size();
    }

    public List<String> getManualLottosInput() {
        return List.copyOf(manualLottosInput);
    }
}
