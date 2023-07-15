package lottogame.controller.request;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoPurchaseRequest {

    private final int money;
    private final int manualLottoCount;
    private final List<Set<Integer>> manualLottos;

    public LottoPurchaseRequest(int money, int manualLottoCount, List<Set<Integer>> manualLottos) {
        this.money = money;
        this.manualLottoCount = manualLottoCount;
        this.manualLottos = manualLottos;
    }

    public int getMoney() {
        return money;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public List<Set<Integer>> getManualLottos() {
        return manualLottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoPurchaseRequest)) return false;
        LottoPurchaseRequest that = (LottoPurchaseRequest) o;
        return money == that.money && manualLottoCount == that.manualLottoCount && Objects.equals(manualLottos, that.manualLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, manualLottoCount, manualLottos);
    }

    @Override
    public String toString() {
        return "LottoPurchaseRequest{" +
                "money=" + money +
                ", manualLottoCount=" + manualLottoCount +
                ", manualLottos=" + manualLottos +
                '}';
    }
}
