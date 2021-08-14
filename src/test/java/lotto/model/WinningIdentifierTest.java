package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
class WinningIdentifierTest {

    private LottoTicket winningTicket;
    private WinningIdentifier winningIdentifier;

    @BeforeEach
    void 설정() {
        winningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningIdentifier = new WinningIdentifier(winningTicket);
    }

    @Test
    void 로또_2개이하_일치_확인() {
        LottoTicket lottoTicketMatchTwo = new LottoTicket(Arrays.asList(1, 2, 7, 8, 9, 10));
        LottoTicket lottoTicketMatchOne = new LottoTicket(Arrays.asList(1, 11, 7, 8, 9, 10));
        LottoTicket lottoTicketMatchZero = new LottoTicket(Arrays.asList(12, 11, 7, 8, 9, 10));

        assertThat(winningIdentifier.checkWinning(lottoTicketMatchTwo)).isEqualTo(Rank.MISS);
        assertThat(winningIdentifier.checkWinning(lottoTicketMatchOne)).isEqualTo(Rank.MISS);
        assertThat(winningIdentifier.checkWinning(lottoTicketMatchZero)).isEqualTo(Rank.MISS);
    }

    @Test
    void 로또_3개_일치_확인() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(winningIdentifier.checkWinning(lottoTicket)).isEqualTo(Rank.THIRD);
    }

    @Test
    void 로또_4개_일치_확인() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 8, 9));
        assertThat(winningIdentifier.checkWinning(lottoTicket)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 로또_5개_일치_확인() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 9));
        assertThat(winningIdentifier.checkWinning(lottoTicket)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 로또_6개_일치_확인() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningIdentifier.checkWinning(lottoTicket)).isEqualTo(Rank.SIXTH);
    }

}