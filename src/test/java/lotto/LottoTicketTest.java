package lotto;

import lotto.domain.ticket.LottoTicket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 번호에서 당첨 번호와 일치하는 번호의 수를 반환한다.")
    void 일치하는_번호_수() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(10, 13, 39, 5, 23, 31));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        String[] winningNumbers = new String[]{"39", "5", "31", "1", "40", "7"};
        long matchNumberCount = lottoTicket.findMatchCount(winningNumbers);

        Assertions.assertThat(matchNumberCount).isEqualTo(3);
    }
}
