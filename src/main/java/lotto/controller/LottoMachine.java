package lotto.controller;

import lotto.domain.Dollars;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.Statistics;
import lotto.utils.IntegerParser;

import java.util.Collections;
import java.util.List;

import static lotto.utils.Validator.checkNotNull;

public class LottoMachine {

    public static LottoTicket publish(int won) {
        return LottoTicket.publish(new Dollars(won), Collections::shuffle);
    }

    public static Statistics rank(LottoTicket lottoTicket, String winningNumbers) {
        checkNotNull(lottoTicket);
        List<Integer> numbers = IntegerParser.listOf(winningNumbers);
        return lottoTicket.rank(LottoNumbers.of(numbers));
    }
}
