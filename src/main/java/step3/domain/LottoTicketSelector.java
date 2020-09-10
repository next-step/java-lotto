package step3.domain;

import step3.utils.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketSelector {

    private List<Integer> LOTTO_NUMBER_POOL = new ArrayList<>();
    private List<LottoTicket> lottoTickets;
    private int amount;

    public LottoTicketSelector(int amount) {
        this.amount = amount;
        IntStream.rangeClosed(Constant.LOTTO_START_NUMBER, Constant.LOTTO_LAST_NUMBER).forEach(LOTTO_NUMBER_POOL::add);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public List<Integer> getLottoNumberPool() {
        return LOTTO_NUMBER_POOL;
    }

    public int getAmount() {
        return amount;
    }

    public int calculateAvailableTicketCount() {
        return this.amount/1000;
    }

    public LottoTicket buySingleLottoTicket(){
        List<Integer> pickedNumbers = new ArrayList<>();

        Collections.shuffle(LOTTO_NUMBER_POOL);
        IntStream.range(Constant.ZERO, Constant.LOTTO_NUMBER_COUNT).forEach(i -> pickedNumbers.add(LOTTO_NUMBER_POOL.get(i)));
        Collections.sort(pickedNumbers);

        return new LottoTicket(pickedNumbers);
    }

    public void buyAvailableLottoTickets(int ticketCount) {
        lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(buySingleLottoTicket());
        }
    }

}
