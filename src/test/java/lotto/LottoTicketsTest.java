package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 수익률 계산")
    public void returnRate() {
        LottoTickets lottoTickets = new LottoTickets(List.of("1, 2, 3, 41, 42, 43"), "1, 2, 3, 4, 5, 6");
        assertThat(lottoTickets.calculateReturn()).isEqualTo(5);
    }


}
