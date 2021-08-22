package lotto.domain;

import lotto.domain.generator.AutoLottoTicketGenerator;
import lotto.domain.generator.LottoMachine;
import lotto.domain.generator.LottoTicketGenerator;
import lotto.domain.generator.ManualLottoTicketGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LottoMachineTest {
    LottoMachine lottoMachine;

    @BeforeAll
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void 로또머신의_자동생성기능_이용하여_3장_생성을_시도하면_3장의_로또티켓객체를_가진_리스트가_생성된다() {
        int autoLottoTicketCount = 3;
        List<LottoTicket> lottoTickets = lottoMachine.autoCreate(autoLottoTicketCount);
        assertThat(lottoTickets.size()).isEqualTo(autoLottoTicketCount);
        lottoTickets.forEach(lottoTicket -> assertThat(lottoTicket).isInstanceOf(LottoTicket.class));
    }

    @Test
    void 로또머신의_수동생성기능_이용하여_티켓_생성을_시도하면_1장의_로또티켓객체가_생성된다() {
        LottoTicket lottoTicket = lottoMachine.manualCreate(1, 2, 3, 4, 5, 6);
        assertThat(lottoTicket.toLottoBallSet().toArray()).containsExactly(
            LottoBall.select(1), LottoBall.select(2), LottoBall.select(3),
            LottoBall.select(4), LottoBall.select(5), LottoBall.select(6));
    }
}
