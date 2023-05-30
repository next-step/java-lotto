package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoWinTest {

    @Test
    void 로또_한장_당첨_확인하기() {
        // Given
        Integer[] winNumber = {1, 2, 3, 4, 5, 6};
        LottoWin lottoWin = new LottoWin(winNumber);

        // When
        Integer[] testNumber = {1, 2, 3, 4, 7, 8};
        LottoTicket lottoTicket = new LottoTicket(testNumber);

        lottoWin.countMatchingNumber(lottoTicket);

        // then
        assertThat(lottoWin.isMatchingCount(4)).isTrue();
    }
}