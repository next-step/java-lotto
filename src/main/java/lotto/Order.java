package lotto;

public class Order {

    private final static Integer UNIT_PRICE = 1000;

    private int orderAmount;

    public Order(int orderAmount) {
        verifyBuyMinimum(orderAmount);
        this.orderAmount = orderAmount;
    }

    public int getAvailableNumberToBuy() {
        return this.orderAmount / UNIT_PRICE;
    }

    private void verifyBuyMinimum(int orderAmount) {
        if(orderAmount < UNIT_PRICE) {
            throw new IllegalArgumentException("이걸론 한장도 못사");
        }
    }

}
