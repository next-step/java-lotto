package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("다수의 로또 티켓 저장")
    public void add() throws Exception {
        LottoTickets lottoTickets = new LottoTickets(new ArrayList<>());
        lottoTickets.add(new LottoTicket(new LottoNumbers()));
        lottoTickets.add(new LottoTicket(new LottoNumbers()));
        assertThat(lottoTickets.lottoTickets()).hasSize(2);
    }

    @Test
    @DisplayName("로또 티켓이 보너스 볼을 포함하는 지 여부")
    public void hasBonusNumber() throws Exception {
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(1,2,3,4,5,6));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        assertThat(lottoTicket.hasBonusNumber(new BonusBall(1))).isTrue();
        assertThat(lottoTicket.hasBonusNumber(new BonusBall(7))).isFalse();
    }
}
