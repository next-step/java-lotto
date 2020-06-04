package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {
    @Test
    void lottoTicketTest() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(3);
        lottoNumbers.add(5);
        lottoNumbers.add(8);
        lottoNumbers.add(11);
        lottoNumbers.add(14);
        lottoNumbers.add(40);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        assertThat(lottoTicket.matchWinningNumber(lottoNumbers)).isEqualTo(6);
    }

    @Test
    void negativeAmountTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<Integer> lottoNumbers = new ArrayList<>();
                    lottoNumbers.add(-3);
                    lottoNumbers.add(5);
                    lottoNumbers.add(8);
                    lottoNumbers.add(-11);
                    lottoNumbers.add(14);
                    lottoNumbers.add(40);
                    LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
                    lottoTicket.matchWinningNumber(lottoNumbers);
                });
    }
}
