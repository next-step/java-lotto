package lotto.model;

import util.StringUtils;

public class LottoCount {
    private final static String MANUAL_COUNT_ERROR_MESSAGE = "구입 금액보다 수동 로또 개수가 더 많습니다.";
    private final static String MANUAL_COUNT_PARSING_ERROR_MESSAGE = "수동 로또 개수는 0 혹은 양수여야 합니다.";

    private int totalCount;
    private int autoCount;
    private int manualCount;

    public LottoCount(int amount, String manualCount){
        this.totalCount = getTotalCount(amount);

        if(!StringUtils.isPositiveNumber(manualCount)){
            throw new IllegalArgumentException(MANUAL_COUNT_PARSING_ERROR_MESSAGE);
        }

        this.manualCount = Integer.parseInt(manualCount);

        if(this.totalCount < this.manualCount){
            throw new IllegalArgumentException(MANUAL_COUNT_ERROR_MESSAGE);
        }

        this.autoCount= totalCount - this.manualCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }

    private int getTotalCount(int amount) {
        return amount / Lotto.PRICE;
    }
}
