package lotto.model;

public class Amount {
    private static final int ZERO = 0;
    private static final int HUNDRED = 100;;
    private long value;
    private long originalValue;

    public Amount(long value) {
        this.value = value;
        this.originalValue = value;
    }

    /**
     * 수익률 가져오기
     *
     * @param moneyAmount
     * @return
     */
    public double getProfitRate(int profit) {
        double profitRate = (double) profit / originalValue;
        if (Double.isNaN(profitRate)) {
            return 0;
        }

        return profitRate;
    }

    /**
     * 수익률 가져오기 100을 기준으로
     *
     * @param moneyAmount
     * @return
     */
    public double getProfitRate_100(int profit) {
        return getProfitRate(profit) * HUNDRED;
    }
    /**
     * 빼기
     *
     * @param num
     */
    public void purcharseTicket(long num) {
        long totalAmount = num * Ticket.PRICE;
        if (!canPurcharse(num)) {
            throw new IllegalArgumentException("더 이상 뺄 수 없습니다.");
        }

        this.value -= totalAmount;
    }

    /**
     * 구매 가능한가?
     *
     * @param num
     * @return
     */
    public boolean canPurcharse(long num) {
        return num * Ticket.PRICE <= value;
    }

    public long getValue() {
        return value;
    }

    public long getOriginalValue() {
        return originalValue;
    }
}
