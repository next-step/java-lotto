package lotto.domain;

import lotto.domain.common.Money;

/**
 * Created by hspark on 07/11/2018.
 */
public class LottoConstants {
	public static final Money LOTTO_TICKET_AMOUNT = Money.of(1_000);
	public static final int LOTTO_NUMBER_COUNT = 6;
	public static final int LOTTO_MAX_NUMBER = 45;
	public static final int LOTTO_MIN_NUMBER = 1;
}
