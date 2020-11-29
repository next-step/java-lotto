package lotto.model;

import lotto.model.lotto.Lotto;
import util.StringUtils;

public class LottoPrice {
    private final static String BUY_MESSAGE = "수동으로 %d개, 자동으로 %d개를 구매했습니다.";
    private final static String MANUAL_PRICE_ERROR_MESSAGE = "구입 금액보다 수동 로또 개수가 더 많습니다.";
    private final static String MANUAL_COUNT_PARSING_ERROR_MESSAGE = "수동 로또 개수는 0 혹은 양수여야 합니다.";

    private int totalCount;
    private int autoCount;
    private int manualCount;

    public LottoPrice(int amount, String manualCount){
        this.totalCount = calculateTotalCount(amount);

        if(!StringUtils.isPositiveNumber(manualCount)){
            throw new IllegalArgumentException(MANUAL_COUNT_PARSING_ERROR_MESSAGE);
        }

        this.manualCount = Integer.parseInt(manualCount);

        if(this.totalCount < this.manualCount){
            throw new IllegalArgumentException(MANUAL_PRICE_ERROR_MESSAGE);
        }

        this.autoCount= totalCount - this.manualCount;
    }

    public int totalPrice() {
        return calculatePrice(totalCount);
    }

    public int manualPrice() {
        return calculatePrice(manualCount);
    }

    public int autoPrice() {
        return calculatePrice(autoCount);
    }

    private int calculateTotalCount(int amount) {
        return amount / Lotto.PRICE;
    }

    private int calculatePrice(int count){
        return count * Lotto.PRICE;
    }

    @Override
    public String toString() {
        return String.format(BUY_MESSAGE, manualCount, autoCount);
    }
}
