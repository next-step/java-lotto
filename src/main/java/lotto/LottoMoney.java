package lotto;

import type.DecimalType;
import utils.NumberUtils;

import java.math.BigDecimal;

public class LottoMoney {

	private static final int LOTTO_PRICE = 1000;
	private static final BigDecimal DEFAULT_REVENUE_VALUE = BigDecimal.ZERO;

	private final int price;

	public LottoMoney(final int price){
		if (price <= 0) {
			throw new IllegalArgumentException();
		}
		this.price = price;
	}

	public int calculateLottoCount(){
		return Integer.divideUnsigned(price, LOTTO_PRICE);
	}

	public BigDecimal calculateRevenue(final SumResult lottoResult){
		if (lottoResult == null) {
			return DEFAULT_REVENUE_VALUE;
		}
		return NumberUtils.mathRound(BigDecimal.valueOf(lottoResult.sumRevenue()),
									 BigDecimal.valueOf(price),
									 DecimalType.PLACE_TWO);
	}
}
