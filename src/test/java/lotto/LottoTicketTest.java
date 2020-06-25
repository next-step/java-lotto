package lotto;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {
    @Test
    void lottoTicketTest() {
        Set<Integer> lottoNumbers = new TreeSet<>();
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
                    Set<Integer> lottoNumbers = new TreeSet<>();
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
