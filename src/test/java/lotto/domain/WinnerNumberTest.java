package lotto.domain;


import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerNumberTest {

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 IllegalArgumentException 발생한다.")
    void exception() {

        assertSoftly(softly -> {
            assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinnerNumber(List.of(1,2,3,4), 8));
            assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinnerNumber(List.of(1,2,3,4,5,6,7), 8));
        });
    }

    @Test
    @DisplayName("당첨 번호와 맞는 개수를 반환한다.")
    void winnerMatch() {
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6), 8);
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));

        assertThat(winnerNumber.matchCount(lottoTicket.getLottoNumbers())).isEqualTo(5);
    }
}
