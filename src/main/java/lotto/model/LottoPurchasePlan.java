package lotto.model;

public class LottoPurchasePlan {
    private final Count manual;
    private final Count auto;

    public LottoPurchasePlan(Money purchaseAmount, int manual) {
        this(purchaseAmount, new Count(manual));
    }

    public LottoPurchasePlan(Money purchaseAmount, Count manual) {
        this(manual, purchaseAmount.countBuyableLottoTickets().subtract(manual), purchaseAmount);
    }

    private LottoPurchasePlan(Count manual, Count auto, Money purchaseAmount) {
        final Count totalCounts = purchaseAmount.countBuyableLottoTickets();
        if (!isValid(manual, auto, totalCounts)) {
            throw new IllegalArgumentException(String.format("수동 로또 개수는 %s개 이하여야 합니다.", totalCounts));
        }
        this.auto = auto;
        this.manual = manual;
    }

    private boolean isValid(Count manual, Count auto, Count totalCounts) {
        if (manual.isBiggerThan(totalCounts)) {
            return false;
        }
        return totalCounts.equals(manual.add(auto));
    }

    public Count manualCount() {
        return manual;
    }

    public Count autoCount() {
        return auto;
    }

    public Count totalCount() {
        return auto.add(manual);
    }
}
