package lotto.domain;

import java.math.BigDecimal;

public class Purchase {

    public static final int LOTTO_TICKET_PRICE = 1_000;
    public static final String DECIMAL_TWO_POINT = "%.2f";
    public static final double REFERENCE_RATIO = 1.0;

    private final int purchase;
    private String rate;

    private Purchase(final String purchase){

        validate(purchase);
        this.purchase = convert(purchase);
        this.rate = String.valueOf(0.0);
    }

    public static Purchase from(final String input) {

        return new Purchase(input);
    }

    private void validate(final String purchase) {

        if (purchase == null || purchase.isBlank()) {
            throw new IllegalArgumentException("구매금액은 입력해야 합니다.");
        }
    }

    private int convert(final String purchase) {

        return Integer.parseInt(purchase);
    }

    public long available() {

        return Math.floorDiv(this.purchase, LOTTO_TICKET_PRICE);
    }

    public void update(final BigDecimal totalPrice) {

        final double result = totalPrice.doubleValue() / this.purchase;
        this.rate = String.format(DECIMAL_TWO_POINT, result);
    }

    public String getRate() {
        return rate;
    }

    public boolean profit() {

        return Double.parseDouble(this.rate) >= REFERENCE_RATIO;
    }
}
