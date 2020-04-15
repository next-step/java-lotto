package lotto.domain;

import aterilio.common.utils.StringUtils;
import lotto.domain.object.Lotto;
import lotto.exception.InvalidFormatException;
import lotto.exception.NegativeElementException;
import lotto.vo.LottoList;
import lotto.vo.LottoResult;

import java.util.Objects;

public class LottoGame {

    private static final int PER_SALE_PRICE = 1000;

    private final int purchaseMoney;
    private final LottoList lottoList;

    public LottoGame(final String totalPurchase) {
        validateNotEmpty(totalPurchase);
        validateNumeric(totalPurchase);
        validatePositive(totalPurchase);
        purchaseMoney = Integer.parseInt(totalPurchase);
        lottoList = new LottoList(purchaseMoney / PER_SALE_PRICE);
    }

    public LottoGame(final int[][] lottoLists) {
        purchaseMoney = (lottoLists == null) ? 0 : lottoLists.length * PER_SALE_PRICE;
        lottoList = new LottoList(Objects.requireNonNull(lottoLists));
    }

    private void validateNotEmpty(final String totalPurchase) {
        if (StringUtils.isNullOrEmpty(totalPurchase)) {
            throw new InvalidFormatException(totalPurchase);
        }
    }

    private void validateNumeric(final String totalPurchase) {
        if (!StringUtils.isNumeric(totalPurchase)) {
            throw new InvalidFormatException(totalPurchase);
        }
    }

    private void validatePositive(final String totalPurchase) {
        int money = Integer.parseInt(totalPurchase);
        if (money < 0) {
            throw new NegativeElementException(totalPurchase);
        }
    }

    public int getCount() {
        return lottoList.getCount();
    }

    public LottoResult getResult(final Lotto luckyNumbers) {
        return lottoList.getResult(luckyNumbers);
    }

    public float getEarningsRate(final int totalPrize) {
        return (float) totalPrize / (getCount() * PER_SALE_PRICE);
    }

    @Override
    public String toString() {
        return lottoList.toString();
    }
}
