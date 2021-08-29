package com.techmoa.lotto.service;

import com.techmoa.lotto.model.LottoWinResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    public void 당청번호_생성() {
        int purcharAmount = 5000;
        LottoService lottoService = new LottoService();
        lottoService.createLotto(purcharAmount);

        assertEquals(5, lottoService.getLottoTickets().getLottoTickets().size());
    }


    @Test
    public void 당첨_체크() {
        LottoService lottoService = new LottoService();
        String inputString = "1, 3, 4, 5, 6, 7";

        LottoAnswer lottoAnswer = LottoAnswer.from(inputString);
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(new LottoTicket().makeLottoNumber());
        lottoTicketList.add(new LottoTicket().makeLottoNumber());
        lottoTicketList.add(new LottoTicket().makeLottoNumber());
        lottoTicketList.add(new LottoTicket().makeLottoNumber());
        lottoTicketList.add(new LottoTicket().makeLottoNumber());
        lottoTicketList.add(new LottoTicket().makeLottoNumber());

        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);

        LottoWinResult lottoWinResult = lottoService.checkWinnings(lottoAnswer , lottoTickets);
        assertEquals(6, lottoWinResult.getResultMap().size());
    }
}