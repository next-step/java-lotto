package lotto.domain.ticket;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 번호에서 당첨 번호와 일치하는 번호의 수를 반환한다.")
    void 일치하는_번호_수() {
        List<Integer> lottoNumbers = List.of(10, 13, 39, 5, 23, 31);

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers.stream()
                                                              .map(LottoNumber::new)
                                                              .collect(Collectors.toList()));

        String[] winningNumbers = new String[]{"10", "39", "4", "1", "23", "31"};
        long matchNumberCount = lottoTicket.findMatchCount(winningNumbers);

        Assertions.assertThat(matchNumberCount).isEqualTo(4);
    }
}
