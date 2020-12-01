package step2.domain;

public class Fee {
    private final int fee;

    public Fee(int fee) {
        if (isNotEnoughFee(fee)){
            throw new IllegalArgumentException("금액이 충분하지 않습니다.");
        }

        this.fee = fee;
    }

    private boolean isNotEnoughFee(int fee) {
        return fee < LottoConstant.NEED_FEE;
    }

    public int getBuyCount() {
        return this.fee / LottoConstant.NEED_FEE;
    }

    public double getFee() {
        return this.fee;
    }
}
