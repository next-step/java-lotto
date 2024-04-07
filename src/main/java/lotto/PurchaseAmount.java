package lotto;

public class PurchaseAmount {

    private int total;
    private int manual;


    private PurchaseAmount(int total, int manual) {
        validAmount(total, manual);
        this.total = total;
        this.manual = manual;
    }

    public int getTotal() {
        return total;
    }

    public int getManual() {
        return manual;
    }

    public int getAuto() {
        return total - manual;
    }

    public static PurchaseAmount of(Money money, int manual) {
        return new PurchaseAmount(money.purchase(), manual);
    }

    private void validAmount(int total, int manual) {
        if (manual > total) {
            throw new IllegalArgumentException("총 입력 갯수보다 수동 생성 갯수가 더 많습니다.");
        }
    }


}
