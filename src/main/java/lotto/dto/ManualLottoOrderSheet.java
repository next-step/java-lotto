package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoOrderSheet {

    private final List<List<Integer>> manualLottoOrders;

    public ManualLottoOrderSheet(List<List<Integer>> manualLottoOrders) {
        this.manualLottoOrders = new ArrayList<>(manualLottoOrders);
    }

    public List<List<Integer>> getManualLottoOrders() {
        return new ArrayList<>(this.manualLottoOrders);
    }

    public int getOrderCount() {
        return manualLottoOrders.size();
    }
}
