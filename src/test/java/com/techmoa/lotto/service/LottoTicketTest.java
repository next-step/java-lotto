package com.techmoa.lotto.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketTest {

    @Test
    public void 복권발행_생성() {

        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.makeLottoNumber();
        List<Integer> lottoNumber = lottoTicket.getLottoNumber();
        boolean isCreate = Arrays.asList(lottoNumber).stream().allMatch(s -> !s.isEmpty());
        assertEquals(true,isCreate);

    }

}
