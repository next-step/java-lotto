package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private final int LOTTO_NUM = 14;


    @Test
    void lottoList() {
        LottoTicket lottoTicket = new LottoTicket(LOTTO_NUM);
        assertThat(lottoTicket.lottoList().size()).isEqualTo(LOTTO_NUM);
    }

    @Test
    void lottoTicket() {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto = new Lotto();
        lottoList.add(lotto);
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        assertThat(lottoTicket.lottoList()).isEqualTo(lottoList);
    }

    @Test
    void addLotto(){
        LottoTicket lottoTicket=new LottoTicket(LOTTO_NUM);
        lottoTicket.addLotto(1);
        assertThat(lottoTicket.lottoList().size()).isEqualTo(LOTTO_NUM+1);
    }

}