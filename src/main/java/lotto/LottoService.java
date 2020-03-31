package lotto;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    public List<Integer> createNonDuplicateNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = LOTTO_FIRST_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        return new ArrayList<>(lottoNumbers.subList(0, 6));
    }

    public List<LottoTicket> buyTickets(int ticketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new LottoTicket(createNonDuplicateNumbers()));
        }
        return lottoTickets;
    }
}
