package lotto.domain;

import aterilio.common.utils.StringUtils;
import lotto.exception.InvalidFormatException;
import lotto.exception.NegativeElementException;
import lotto.vo.LottoList;

public class LottoGame {

    private static final int PER_SALE_PRICE = 1000;

    private final LottoList lottoList;

    public LottoGame(final String totalPurchase) {
        validateNotEmpty(totalPurchase);
        validateNumeric(totalPurchase);
        validatePositive(totalPurchase);
        lottoList = new LottoList(Integer.parseInt(totalPurchase)/PER_SALE_PRICE);
    }

    private void validateNotEmpty(final String totalPurchase) {
        if (StringUtils.isNullOrEmpty(totalPurchase)) {
            throw new InvalidFormatException(totalPurchase);
        }
    }

    private void validateNumeric(final String totalPurchase) {
        if ( !StringUtils.isNumeric(totalPurchase) ) {
            throw new InvalidFormatException(totalPurchase);
        }
    }

    private void validatePositive(final String totalPurchase) {
        int money = Integer.parseInt(totalPurchase);
        if ( money < 0 ) {
            throw new NegativeElementException(totalPurchase);
        }
    }
}
