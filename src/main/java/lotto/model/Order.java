package lotto.model;

public class Order {

    final static Integer UNIT_PRICE = 1000;
    private int handPickCount;
    private int orderAmount;

    public Order(int orderAmount) {
        this(orderAmount, 0);
    }

    public Order(int orderAmount, int handPickCount) {
        verifyBuyMinimum(orderAmount);
        this.orderAmount = orderAmount;

        verifyHanPickCount(handPickCount);
        this.handPickCount = handPickCount;
    }

    public int getAutoPickCount() {
        return getAvailableNumberToBuy() - handPickCount;
    }

    private int getAvailableNumberToBuy() {
        return this.orderAmount / UNIT_PRICE;
    }

    private void verifyHanPickCount(int handPickCount) {
        if(getAvailableNumberToBuy() < handPickCount) {
            throw new IllegalArgumentException("그렇게는 구매할 수 없습니다. 돈을 더 내세요.");
        }
    }

    private void verifyBuyMinimum(int orderAmount) {
        if(orderAmount < UNIT_PRICE) {
            throw new IllegalArgumentException("이걸론 한장도 못사");
        }
    }
}
