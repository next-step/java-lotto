package lotto.request;

import java.util.List;

public class ManualLottoRequest {

    private final List<Integer> manualLottoRequest;

    public ManualLottoRequest(List<Integer> manualLottoRequest) {
        this.manualLottoRequest = manualLottoRequest;
    }

    public List<Integer> getManualLottoRequest() {
        return manualLottoRequest;
    }
}
