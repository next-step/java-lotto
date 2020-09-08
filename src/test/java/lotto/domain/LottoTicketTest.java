package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.common.LottoPriceInfo;
import lotto.common.LottoTicketMachine;
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
        //given
        LottoTicket winningNumber = LottoTicketMachine.issueTicket("2, 3, 4, 5, 6, 7");

        //when
        long matchCount = lottoTicket.matchNumbers(winningNumber);

        //then
        assertEquals(5, matchCount);
    }

    @DisplayName("일치하는 로또번호 갯수 정보 반환")
    @Test
    void matchNumbers2() {
        //given
        LottoTicket winningNumber = LottoTicketMachine.issueTicket("2, 3, 4, 5, 6, 7");

        //when
        LottoPriceInfo lottoPriceInfo = lottoTicket.matchNumbers2(winningNumber);

        //then
        LottoPriceInfo lottoRank2 = LottoPriceInfo.LOTTO_RANK_2;
        assertEquals(lottoRank2, lottoPriceInfo);
    }
}