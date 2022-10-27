package lotto.input;

import java.util.List;

public class ManualLottoInput {
    private final List<String> manualLottoInput;

    public ManualLottoInput(List<String> manualLottoInput) {
        this.manualLottoInput = manualLottoInput;
    }

    public int inputCount(){
        return manualLottoInput.size();
    }

    public List<String> getManualLottoInput() {
        return manualLottoInput;
    }
}
