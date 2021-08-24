package com.techmoa.lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static int purchaseAmount = 0;
    private static int purchaseLottoTicket = 0;
    private static int countLottoTicket = 0;
    private static final int PURCHASE_LOTTO_PRICE = 1000;
    private static LottoTickets lottoTickets = null;

    public void checkLottoAmount(int purchaseAmount) {
        this.countLottoTicket = purchaseAmount / 1000 ;
    }

    public void createLotto(int purchaseAmount){
        checkLottoAmount(purchaseAmount);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for(int i= 0; i< countLottoTicket; i++) {
            LottoTicket lottoTicket = new LottoTicket();
            lottoTicket.makeLottoNumber();
            lottoTicketList.add(lottoTicket);
        }
        lottoTickets = new LottoTickets(lottoTicketList);

    }

    public static LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public void checkWinnings(LottoAnswer lottoAnswer , LottoTickets lottoTickets) {
        lottoAnswer.result(lottoTickets);

    }

    public static int getPurchaseLottoTicket() {
        return purchaseLottoTicket;
    }
}
