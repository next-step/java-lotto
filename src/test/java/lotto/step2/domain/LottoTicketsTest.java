package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    public static final LottoTickets LOTTO_TICKETS = new LottoTickets(Arrays.asList(LottoTicketTest.LOTTO_TICKET, LottoTicketTest.LOTTO_TICKET));
    
    @Test
    @DisplayName("여러장의 로또 생성")
    void create() {
        assertThat(LOTTO_TICKETS).isNotNull();
    }
    
    @Test
    @DisplayName("일치 번호 개수 리스트 반환")
    void numberOfMatches() {
        List<LottoNumber> winningLottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(45));
        List<LottoRank> lottoRanks = LOTTO_TICKETS.parseLottoRanks(new WinningLottoNumbers(winningLottoNumbers, LottoNumberTest.THIRTY));
        assertThat(lottoRanks).isEqualTo(Arrays.asList(LottoRank.SECOND, LottoRank.SECOND));
    }
}