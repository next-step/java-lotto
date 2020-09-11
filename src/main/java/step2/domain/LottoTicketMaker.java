package step2.domain;

import step2.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketMaker {

    private static final List<Integer> LOTTO_NUMBER_POOL = new ArrayList<>();

    public LottoTicketMaker(){
        IntStream.rangeClosed(Constant.LOTTO_START_NUMBER, Constant.LOTTO_LAST_NUMBER).forEach(LOTTO_NUMBER_POOL::add);
    }

    public List<Integer> getLottoNumbers(){
        return LOTTO_NUMBER_POOL;
    }

    public int calculateAvailableCount(int amount){
        return amount/1000;
    }

    public LottoTicket buySingleLottoTicket(){
        List<Integer> numbers = new ArrayList<>();

        Collections.shuffle(LOTTO_NUMBER_POOL);
        for(int i = 0; i < Constant.LOTTO_PICK_COUNT; i++){
            numbers.add(LOTTO_NUMBER_POOL.get(i));
        }
        Collections.sort(numbers);

        return new LottoTicket(numbers);
    }

    public List<LottoTicket> buyAvailableLottoTickets(int ticketCount){
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for(int i = 0; i < ticketCount; i++){
            lottoTickets.add(buySingleLottoTicket());
        }

        return lottoTickets;
    }

}
