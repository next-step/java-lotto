package step2;

public class PurchaseTest implements TheMethodOfPurchase {
    private int amount;

    public PurchaseTest(int amount){
        this.amount = amount;
    }

    @Override
    public void input() {

    }

    @Override
    public int getAmount() {
        return amount;
    }
}
