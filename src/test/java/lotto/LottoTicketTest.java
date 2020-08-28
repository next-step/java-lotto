package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        Set<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toSet());

        lottoTicket = new LottoTicket(lottoNumbers);
    }

    @DisplayName("로또번호들을 받아서 티켓 생성")
    @Test
    void newInstance() {
        //then
        assertThat(lottoTicket).isNotNull();
    }

    @DisplayName("일치하는 로또번호 갯수 반환")
    @Test
    void matchNumbers() {
        //when
        long matchCount = lottoTicket.matchNumbers(lottoTicket);

        //then
        assertEquals(6, matchCount);
    }
}