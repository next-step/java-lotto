package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    private List<LottoTicket> ascendingLottoTickets;
    private List<LottoNumber> ascendingLottoNumbers;
    private LottoTickets lottoTickets;
    
    @BeforeEach
    void setUp() {
        ascendingLottoNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        ascendingLottoTickets = IntStream.range(0, 2)
                .mapToObj(ticketCount -> new LottoTicket(ascendingLottoNumbers))
                .collect(Collectors.toList());
        lottoTickets = new LottoTickets(ascendingLottoTickets);
    }
    
    @Test
    @DisplayName("여러장의 로또 생성")
    void create() {
        assertThat(lottoTickets).isEqualTo(new LottoTickets(ascendingLottoTickets));
    }
    
    @Test
    @DisplayName("일치 번호 개수 리스트 반환")
    void numberOfMatches() {
        List<LottoNumber> winningLottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(45));
        List<LottoRank> lottoRanks = lottoTickets.lottoRanks(winningLottoNumbers);
        assertThat(lottoRanks).isEqualTo(Arrays.asList(LottoRank.SECOND, LottoRank.SECOND));
    }
}