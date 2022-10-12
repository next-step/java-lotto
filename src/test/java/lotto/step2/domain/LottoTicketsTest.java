package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    public LottoTickets lottoTickets;
    
    @BeforeEach
    void setUp() {
        lottoTickets = new LottoTickets(Arrays.asList(LottoTicketTest.LOTTO_TICKET, LottoTicketTest.LOTTO_TICKET));
    }
    
    @Test
    @DisplayName("여러장의 로또 생성")
    void create() {
        assertThat(lottoTickets).isNotNull();
    }
    
    @Test
    @DisplayName("일치 번호 개수 리스트 반환")
    void number_of_matches() {
        final WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,30");
        winningLottoNumbers.inputBonusNumber("6");
        List<LottoRank> lottoRanks = lottoTickets.parseLottoRanks(winningLottoNumbers);
        
        assertThat(lottoRanks).isEqualTo(Arrays.asList(LottoRank.SECOND, LottoRank.SECOND));
    }
    
    @Test
    @DisplayName("수동, 자동 로또 합치기")
    void merge_auto_and_manual_lottos() {
        lottoTickets.mergeAutoLottos(lottoTickets);
        assertThat(lottoTickets.getLottoTickets()).isEqualTo(Arrays.asList(LottoTicketTest.LOTTO_TICKET, LottoTicketTest.LOTTO_TICKET, LottoTicketTest.LOTTO_TICKET, LottoTicketTest.LOTTO_TICKET));
    }
}