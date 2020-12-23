package com.ssabae.nextstep.lotto;

import com.ssabae.nextstep.lotto.domain.Money;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class Constant {

    public final static int LOTTO_MIN_VALUE = 1;
    public final static int LOTTO_MAX_VALUE = 45;
    public final static int LOTTO_NUMBER_SIZE = 6;

    public final static String LOTTO_NUMBER_SEPARATOR = ",";

    public final static Money LOTTO_TICKET_PRICE = Money.won(1_000L);
}
