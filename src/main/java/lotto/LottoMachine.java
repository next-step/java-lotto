package lotto;

import lotto.utils.IntegerParser;

import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public static LottoTicket publish(int won) {
        return LottoTicket.publish(new Dollars(won), Collections::shuffle);
    }

    public static Statistics rank(LottoTicket lottoTicket, String winningNumbers) {
        List<Integer> numbers = IntegerParser.listOf(winningNumbers);
        return lottoTicket.rank(LottoNumbers.of(numbers));
    }
}
