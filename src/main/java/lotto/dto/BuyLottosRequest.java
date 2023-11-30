package lotto.dto;

import java.util.List;

public class BuyLottosRequest {

    private final List<List<Integer>> manualLottos;
    private final long numberOfAllLottos;
    private final long manualLottoCount;

    public BuyLottosRequest(List<List<Integer>> manualLottos, long numberOfAllLottos, long manualLottoCount) {
        this.manualLottos = manualLottos;
        this.numberOfAllLottos = numberOfAllLottos;
        this.manualLottoCount = manualLottoCount;
    }

    public List<List<Integer>> getManualLottos() {
        return manualLottos;
    }

    public long getNumberOfAllLottos() {
        return numberOfAllLottos;
    }

    public long getManualLottoCount() {
        return manualLottoCount;
    }
}
