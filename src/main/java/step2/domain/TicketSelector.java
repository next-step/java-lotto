package step2.domain;

import step2.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicket {

    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoTicket(){
        createLottoNumbers();
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

    public int calculateAvailableCount(int amount){
        return amount/1000;
    }

    public List<Integer> buySingleLottoTicket(){
        List<Integer> lottoTicket = new ArrayList<>();

        Collections.shuffle(lottoNumbers);
        for(int i = 0; i < Constant.LOTTO_PICK_COUNT; i++){
            lottoTicket.add(lottoNumbers.get(i));
        }
        Collections.sort(lottoTicket);

        return lottoTicket;
    }

    public List<List<Integer>> buyAvailableLottoTickets(int ticketCount){
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for(int i = 0; i < ticketCount; i++){
            lottoTickets.add(buySingleLottoTicket());
        }

        return lottoTickets;
    }

    private void createLottoNumbers(){
        IntStream.rangeClosed(Constant.LOTTO_START_NUMBER, Constant.LOTTO_LAST_NUMBER).forEach(lottoNumbers::add);
    }

}
