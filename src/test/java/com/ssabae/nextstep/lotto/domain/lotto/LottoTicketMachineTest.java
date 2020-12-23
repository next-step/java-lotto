package com.ssabae.nextstep.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ssabae.nextstep.lotto.application.LottoResultDto;
import com.ssabae.nextstep.lotto.domain.Money;
import com.ssabae.nextstep.lotto.domain.WinningNumber;
import com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator.LottoTicketGenerator;
import com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator.TestLottoTicketGenerator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
class LottoTicketMachineTest {

    private final LottoTicketGenerator generator = new TestLottoTicketGenerator();
    private final LottoTicketMachine lottoTicketMachine = new LottoTicketMachine(generator);

    @Test
    @DisplayName("로또 기계 All 자동 Test")
    void buyTest() {
        LottoTickets lottoTickets = lottoTicketMachine.buy(Money.won(13000L), Collections.emptyList());
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        assertThat(lottoTicketList.size()).isEqualTo(13);
    }

    @Test
    @DisplayName("로또 기계 자동 & 수동 Test")
    void buyWithManualTest() {
        List<String> manual = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        LottoTickets lottoTickets = lottoTicketMachine.buy(Money.won(13000L), manual);

        assertThat(lottoTickets.getManualTicketCount()).isEqualTo(2);
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(13);
    }

    @Test
    @DisplayName("로또 기계 금액 모자를 경우 Text")
    void shouldBeExceptionByNotEnoughAmountTest() {
        assertThatThrownBy(() -> lottoTicketMachine.buy(Money.won(100L), Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 기계 금액 모자를 경우 Text")
    void shouldBeExceptionByToManyManualTicketTest() {
        List<String> manual = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        assertThatThrownBy(() -> lottoTicketMachine.buy(Money.won(1000L), manual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 기계 금액 계산 Test")
    void calculateYieldTest() {
        List<String> manual = Arrays.asList("1,2,3,4,5,6");

        LottoTickets lottoTickets = lottoTicketMachine.buy(Money.won(2000L), manual);
        WinningNumber winningNumber = new WinningNumber("11, 12, 13, 14, 15, 16", "17");

        LottoResultDto lottoResultDto = lottoTicketMachine.calculateYield(lottoTickets, winningNumber);
        assertThat(lottoResultDto.getEarnRate()).isEqualTo(0.0f);

    }


}
