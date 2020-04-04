package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoOrderSheet {

    private final List<String> manualLottoOrders;

    public ManualLottoOrderSheet(List<String> manualLottoOrders) {
        this.manualLottoOrders = manualLottoOrders;
    }

    public List<String> getManualLottoOrders() {
        return new ArrayList<>(this.manualLottoOrders);
    }

    public int getOrderCount() {
        return manualLottoOrders.size();
    }
}
