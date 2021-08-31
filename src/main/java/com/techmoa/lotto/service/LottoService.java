package com.techmoa.lotto.service;

import com.techmoa.lotto.model.LottoWinResult;
import com.techmoa.lotto.model.LottoWinScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoService {

    private static int purchaseAmount = 0;
    private static final int purchaseLottoTicket = 0;
    private static int countLottoTicket = 0;
    private static final int PURCHASE_LOTTO_PRICE = 1000;

    private static LottoTickets lottoTickets = null;

    public void startLotto(int purchaseAmount){
        LottoService.purchaseAmount = purchaseAmount;
        buyLotto(purchaseAmount);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        LottoTicket lottoTicket = null;
        for(int i= 0; i< countLottoTicket; i++) {
            lottoTicket = new LottoTicket();
            lottoTicketList.add(lottoTicket.makeLottoNumber());
        }
        lottoTickets = new LottoTickets(lottoTicketList);
    }

    public void buyLotto(int purchaseAmount) {
        countLottoTicket = purchaseAmount / PURCHASE_LOTTO_PRICE ;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }


}
