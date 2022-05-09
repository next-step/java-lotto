package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;


    public int calculateTicketCnt(int money){
        if(money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("구입금액은 1000의 배수여야합니다.");
        }
        return money / LOTTO_PRICE;
    }

    public List<LottoTicket> generateTickets(int ticketCnt, LottoTicketGenerator lottoTicketGenerator){
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCnt; i++) {
            LottoTicket lottoTicket = lottoTicketGenerator.generateNumberList();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public LottoResult start(List<LottoTicket> lottoTickets, LottoTicket preWinningLottoTicket) {
        LottoResult lottoResult = new LottoResult();

        for(LottoTicket lottoTicket: lottoTickets){
            int coincidenceCnt = lottoTicket.getCoincidenceCnt(preWinningLottoTicket);
            if(coincidenceCnt >= 3){
                lottoResult.addCoincidenceCnt(coincidenceCnt);
            }
        }

        return lottoResult;
    }




}
