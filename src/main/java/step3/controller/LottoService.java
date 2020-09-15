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
        List numbers = new ArrayList();
        for(int i = 0 ; i < 45 ; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList( 0, 6 );
        return numbers;
    }
}
