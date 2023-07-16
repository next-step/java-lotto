package lotto.request;

import java.util.List;
import java.util.stream.Collectors;

public class ManualRequest {

    private final List<ManualLottoRequest> manualLottos;

    public ManualRequest(List<List<Integer>> manualLottos) {
        this.manualLottos = manualLottos.stream()
                .map(ManualLottoRequest::new)
                .collect(Collectors.toList());
    }

    public List<ManualLottoRequest> getManualLottos() {
        return manualLottos;
    }

    public long size() {
        return manualLottos.size();
    }
}
