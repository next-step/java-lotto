package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓 1장 생성 성공")
    void create() {
        List<Number> expected = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            expected.add(new Number(i+1));
        }

        LottoTicket lottoTicket = new LottoTicket(expected);

        assertThat(lottoTicket.getNumbers())
                .isSameAs(expected);
    }
}
