package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("automaticIssuance() 테스트 - 로또티켓 자동 발급 메소드")
    @Test
    void automaticIssuance() {
        // given
        List<LottoTicket> expected = getLottoTickets();

        // when
        List<LottoTicket> lottoTickets = LottoMachine.automaticIssuance(new PurchasePrice(3000), new FixedLottoNumberMaker());

        // then
        assertThat(lottoTickets).isEqualTo(expected);
    }

    @DisplayName("manualIssuance() 테스트 - 로또티켓 수동 발급 메소드")
    @Test
    void manualIssuance() {
        // given
        List<LottoTicket> expected = getLottoTickets();

        // when
        List<LottoTicket> lottoTickets = LottoMachine.manualIssuance(getLottoNumbers());

        // then
        assertThat(lottoTickets).isEqualTo(expected);
    }

    private List<LottoTicket> getLottoTickets() {
        List<LottoTicket> lottoTickets = new LinkedList<>();
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));

        return lottoTickets;
    }

    private List<List<Integer>> getLottoNumbers() {
        List<List<Integer>> lottoTickets = new LinkedList<>();
        lottoTickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));

        return lottoTickets;
    }
}
