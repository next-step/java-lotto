package com.game.lotto.number;

import java.util.ArrayList;
import java.util.List;

public abstract class LottoNumberGenerator {
    public static final int LOTTO_NUMBER_SELECT_COUNT = 6;
    public static final Integer MAX_VALUE_OF_LOTTO_NUMBER = 45;
    public static final Integer MIN_VALUE_OF_LOTTO_NUMBER = 1;
    private static final List<Integer> TOTAL_NUMBERS_OF_LOTTO_TICKET;

    static {
        TOTAL_NUMBERS_OF_LOTTO_TICKET = new ArrayList<>();
        for (int index = MIN_VALUE_OF_LOTTO_NUMBER; index <= MAX_VALUE_OF_LOTTO_NUMBER; index++) {
            TOTAL_NUMBERS_OF_LOTTO_TICKET.add(index);
        }
    }

    public static List<Integer> getTotalNumbersOfLottoTicket() {
        return TOTAL_NUMBERS_OF_LOTTO_TICKET;
    }

    public abstract List<Integer> generateNumbers();
}
