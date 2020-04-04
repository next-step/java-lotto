package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoOrderSheet {

    private final List<int[]> manualLottoOrders;

    public ManualLottoOrderSheet(List<int[]> manualLottoOrders) {
        this.manualLottoOrders = manualLottoOrders;
    }

    public List<int[]> getManualLottoOrders() {
        return new ArrayList<>(this.manualLottoOrders);
    }

    public int getOrderCount() {
        return manualLottoOrders.size();
    }
}
