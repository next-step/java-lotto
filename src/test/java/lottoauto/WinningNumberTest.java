package lottoauto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test
    void checkWinning() {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6));
        LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,7)));

        winningNumber.checkWinning(lottoTicket);
        assertThat(lottoTicket.hitCount()).isEqualTo(new HitCount(5));
    }
}
