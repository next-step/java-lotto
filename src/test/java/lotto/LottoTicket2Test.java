package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicket2Test {
    private Set<LottoNumber> lottoNumbers;
    private LottoTicket2 lottoTicket2;

    @BeforeEach
    void setUp() {
        lottoNumbers = IntStream.rangeClosed(1, 6)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toSet());

        lottoTicket2 = new LottoTicket2(lottoNumbers);
    }

    @DisplayName("로또번호들을 받아서 티켓 생성")
    @Test
    void newInstance() {
        //then
        assertThat(lottoTicket2).isNotNull();
    }

    @DisplayName("일치하는 로또번호 갯수 반환")
    @Test
    void matchNumbers() {
        //when
        long matchCount = lottoTicket2.matchNumbers(lottoNumbers);

        //then
        assertEquals(6, matchCount);
    }
}