package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    public static final int LOTTO_MAXNUMS = 45;

    LottoMachine lottoMachine;


    @Test
    public void 로또_번호_45개_생성() {
        lottoMachine = new LottoMachine();
        List<Integer> numbers = lottoMachine.createNumbers();
        assertThat(numbers.size()).isEqualTo(45);
    }

    @Test
    public void 받은가격_만큼의_로또티켓_생성() {
        lottoMachine = new LottoMachine();
        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTicket(2000);
        assertThat(lottoTickets.size()).isEqualTo(2);
    }





}
