package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoRule.*;

public class LottoMachine {
    public static List<LottoTicket> pay(long money) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < getTicketCount(money); i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    private static LottoTicket generateLottoTicket() {
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number = getLottoStartNumber(); number < getLottoEndNumber(); number++) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0, getLottoNumbersSize()));
    }

    private static long getTicketCount(long money) {
        return money / getPrice();
    }
}
