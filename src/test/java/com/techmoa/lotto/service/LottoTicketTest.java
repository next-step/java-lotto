package com.techmoa.lotto.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketTest {

    @Test
    public void 복권발행_생성() {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.makeLottoNumber();
        int[] lottoNumber = lottoTicket.getLottoNumber();
        //Arrays.asList(lottoNumber).stream().allMatch();
        assertEquals(lottoNumber,lottoTicket.getLottoNumber());

    }

    @Test
    public void 당청번호_생성() {

    }
}
