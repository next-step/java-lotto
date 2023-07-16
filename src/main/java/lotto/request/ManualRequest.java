package lotto.request;

import java.util.List;

public class ManualRequest {

    private final List<List<Integer>> manualLottos;

    public ManualRequest(List<List<Integer>> manualLottos) {
        this.manualLottos = manualLottos;
    }

    public List<List<Integer>> getManualLottos() {
        return manualLottos;
    }
}
