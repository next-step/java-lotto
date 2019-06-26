package lotto.view.data;

public class LottoBuyingInfo {
    private int cashPayment;
    private int selfCount;
    
    public LottoBuyingInfo(int cashPayment, int selfCount) {
        this.cashPayment = cashPayment;
        this.selfCount = selfCount;
    }
    
    public int getCashPayment() {
        return cashPayment;
    }
    
    public int getSelfCount() {
        return selfCount;
    }
}
