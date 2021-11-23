package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @Test
    @DisplayName("생성성공")
    void createSuccess() {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets = lottoTickets.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottoTickets.size()).isEqualTo(1);
    }

}
