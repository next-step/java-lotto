package lotto.tool;

import lotto.domain.LottoTicket;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    //TODO : 로또한장 발급,  여러장 발급

    //숫자전달 -> LottoAutoGenerator
    //  -> lottoBalls 전달 -> LottoTicket에 담아서 반환

    @Test
    public void 로또한장_발급하기() {
        List<LottoTicket> lottoTickets = LottoMachine.issueTickets(1);
        System.out.println(lottoTickets.get(0).toString());
        assertThat(lottoTickets.get(0) != null).isEqualTo(true);
    }

    @Test
    public void 로또_5장_발급() {
        List<LottoTicket> lottoTickets = LottoMachine.issueTickets(5);
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
        assertThat(lottoTickets.size()).isEqualTo(5);
    }
}
