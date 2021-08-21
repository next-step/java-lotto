package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoTicketOffice {

    public static final int PRICE = 1000;

    private final List<Integer> lottoNumber;

    public LottoTicketOffice() {
        lottoNumber = IntStream.rangeClosed(LottoNumber.RANGE_MIN, LottoNumber.RANGE_MAX)
                .boxed()
                .collect(toList());
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
        return lottoNumber.stream()
                .limit(LottoTicket.SIZE)
                .sorted()
                .collect(collectingAndThen(toList(), LottoTicket::of));
    }
}
