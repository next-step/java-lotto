package step3.controller;

import step3.domain.LottoTicket;
import step3.domain.LottoTickets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public LottoTicket createLottoNumber() throws IllegalAccessException {
        LottoTicket lottoTicket = new LottoTicket(createNumbers());
        return lottoTicket;
    }

    private List<Long> createNumbers() {
        List<Long> numbers = new ArrayList();
        for(int i = 0 ; i < 45 ; i++) {
            numbers.add((long) (i + 1));
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList( 0, 6 );
        Collections.sort(numbers);
        return numbers;
    }

    public LottoTickets createLottoTicket(int count) throws IllegalAccessException {
        List<LottoTicket> lottoTicket = new ArrayList<>();
        for(int i = 0 ; i < count ; i++) {
            lottoTicket.add(createLottoNumber());
        }
        LottoTickets lottoTickets = new LottoTickets(lottoTicket);
        return lottoTickets;
    }
}
