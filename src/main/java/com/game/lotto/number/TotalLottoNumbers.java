package com.game.lotto.number;


import java.util.ArrayList;
import java.util.List;

import static com.game.lotto.number.LottoNumber.MAX_VALUE_OF_LOTTO_NUMBER;
import static com.game.lotto.number.LottoNumber.MIN_VALUE_OF_LOTTO_NUMBER;

public class TotalLottoNumbers {
    private static final List<LottoNumber> TOTAL_NUMBERS_OF_LOTTO_TICKET;

    static {
        TOTAL_NUMBERS_OF_LOTTO_TICKET = new ArrayList<>();
        for (int index = MIN_VALUE_OF_LOTTO_NUMBER; index <= MAX_VALUE_OF_LOTTO_NUMBER; index++) {
            TOTAL_NUMBERS_OF_LOTTO_TICKET.add(new LottoNumber(index));
        }
    }

    public static List<LottoNumber> getTotalNumbersOfLottoTicket() {
        return TOTAL_NUMBERS_OF_LOTTO_TICKET;
    }
}
