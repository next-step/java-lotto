package step3.controller;

import step3.domain.LottoTicket;

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

    public List<LottoTicket> createLottoTicket(int count) throws IllegalAccessException {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i = 0 ; i < count ; i++) {
            lottoTickets.add(createLottoNumber());
        }
        return lottoTickets;
    }
}
