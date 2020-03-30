package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    static final int LOTTO_START_NUMBER = 1;
    static final int LOTTO_END_NUMBER = 45;

    public static List<LottoTicket> pay(long money) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < getTicketCount(money); i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    private static LottoTicket generateLottoTicket() {
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number = LOTTO_START_NUMBER; number < LOTTO_END_NUMBER; number++) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0, LottoTicket.LOTTO_NUMBERS_SIZE));
    }

    private static long getTicketCount(long money) {
        return money / LottoTicket.PRICE;
    }
}
