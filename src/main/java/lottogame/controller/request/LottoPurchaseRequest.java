package lottogame.controller.request;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoPurchaseRequest {

    private final int money;
    private final int manualLottoCount;
    private final List<Set<Integer>> manualLottoNumbersList;

    public LottoPurchaseRequest(int money, int manualLottoCount, List<Set<Integer>> manualLottoNumbersList) {
        this.money = money;
        this.manualLottoCount = manualLottoCount;
        this.manualLottoNumbersList = manualLottoNumbersList;
    }

    public int getMoney() {
        return money;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public List<Set<Integer>> getManualLottoNumbersList() {
        return manualLottoNumbersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoPurchaseRequest)) return false;
        LottoPurchaseRequest that = (LottoPurchaseRequest) o;
        return money == that.money && manualLottoCount == that.manualLottoCount && Objects.equals(manualLottoNumbersList, that.manualLottoNumbersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, manualLottoCount, manualLottoNumbersList);
    }

    @Override
    public String toString() {
        return "LottoPurchaseRequest{" +
                "money=" + money +
                ", manualLottoCount=" + manualLottoCount +
                ", manualLottoNumbersList=" + manualLottoNumbersList +
                '}';
    }
}
