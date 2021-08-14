package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketOffice {

    private static final int PRICE = 1000;
    private static final int MAX = 45;
    private static final int MIN = 1;
    private List<Integer> lottoNumber;

    public LottoTicketOffice() {
        lottoNumber = IntStream.range(MIN, MAX + 1).boxed().collect(Collectors.toList());
    }

    public List<LottoTicket> buyLotto(int amount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amount / PRICE; i++) {
            lottoTickets.add(publishLottoTicket());
        }
        return lottoTickets;
    }

    private LottoTicket publishLottoTicket() {
        Collections.shuffle(lottoNumber);
        Collections.sort(lottoNumber);
        return new LottoTicket(lottoNumber.stream().limit(6).collect(Collectors.toList()));
    }
}
