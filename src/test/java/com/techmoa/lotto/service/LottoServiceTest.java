package com.techmoa.lotto.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    public void 복권발행_티켓수확인() {
        int purcharAmount = 5000;
        LottoService lottoService = new LottoService();
        lottoService.createLotto(purcharAmount);

        assertEquals(5, lottoService.getLottoTickets().getLottoTickets().size());
    }

    @Test
    public void 당청번호_생성() {

    }
}