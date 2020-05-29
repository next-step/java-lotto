package lotto.domain;

import lotto.vo.Money;

public class LottoGameProperty {
    public static final int LOTTO_NUMBER_BEGIN_BOUND = 1;
    public static final int LOTTO_NUMBER_END_BOUND = 45;
    public static final int COUNT_OF_LOTTO_NUMBER = 6;

    public static final Money LOTTO_TICKET_PRICE = Money.of(1000);
}
