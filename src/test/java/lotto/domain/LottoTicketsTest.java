package lotto.domain;

import lotto.utils.LottoRandomNumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("다수의 로또 티켓 저장")
    public void add() throws Exception {
        LottoTickets lottoTickets = new LottoTickets(new ArrayList<>());
        List<Integer> lottoNumbers = LottoRandomNumberUtil.lottoNumbers();
        lottoTickets.add(new LottoTicket(new LottoNumbers(lottoNumbers)));
        lottoTickets.add(new LottoTicket(new LottoNumbers(lottoNumbers)));
        assertThat(lottoTickets.lottoTickets()).hasSize(2);
    }
}
