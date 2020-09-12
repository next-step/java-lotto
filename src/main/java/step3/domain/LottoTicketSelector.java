package step3.domain;

import step3.utils.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketSelector {

    private List<Integer> LOTTO_NUMBER_POOL = new ArrayList<>();
    private List<LottoTicket> lottoTickets = new ArrayList<>();
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
        return this.amount/1000 - lottoTickets.size();
    }

    public LottoTicket buySingleAutoLottoTicket(){
        List<Integer> autoPickedNumbers = new ArrayList<>();

        Collections.shuffle(LOTTO_NUMBER_POOL);
        IntStream.range(Constant.ZERO, Constant.LOTTO_NUMBER_COUNT).forEach(i -> autoPickedNumbers.add(LOTTO_NUMBER_POOL.get(i)));
        Collections.sort(autoPickedNumbers);

        return new LottoTicket(autoPickedNumbers);
    }

    public void buyAvailableAutoLottoTickets(int ticketCount) {

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(buySingleAutoLottoTicket());
        }

    }

    public void buySingleManualLottoTicket(String ticketNumbers){
        List<Integer> manualPickedNumbers = new ArrayList<>();
        for(String number : ticketNumbers.split(Constant.MANUAL_NUMBER_SEPERATOR)){
            checkNumberRange(number);
            manualPickedNumbers.add(Integer.parseInt(number));
        }
        Collections.sort(manualPickedNumbers);
        lottoTickets.add(new LottoTicket(manualPickedNumbers));
    }

    private void checkNumberRange(String number){
        if((Integer.parseInt(number) < Constant.LOTTO_START_NUMBER) || (Constant.LOTTO_LAST_NUMBER < Integer.parseInt(number))){
            throw new IllegalArgumentException();
        }
    }

}
