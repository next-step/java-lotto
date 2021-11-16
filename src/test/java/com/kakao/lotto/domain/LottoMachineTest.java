package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.PurchaseInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 생성기에서는 로또 금액만큼의 로또 티켓을 생성한다.")
    void makeRandomLottoTicketSize() {
        LottoMachine lottoMachine = new LottoMachine(new PurchaseInfo(15000));
        List<LottoTicket> lottoTickets = lottoMachine.makeLottoTickets();
        assertThat(lottoTickets.size()).isEqualTo(15);
    }

}
