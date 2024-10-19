package lotto.domain.ticket;

import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    private WinningNumbers winningNumbers;

    @BeforeEach
    void before() {
        winningNumbers = getWinningNumbers();
    }

    @Test
    @DisplayName("로또 번호에서 당첨 번호와 일치하는 번호의 개수를 반환한다.")
    void 일치하는_번호_개수() {
        List<Integer> lottoNumbers = List.of(10, 13, 39, 5, 23, 31);

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers.stream()
                                                              .map(LottoNumber::new)
                                                              .collect(Collectors.toList()));

        long matchNumberCount = lottoTicket.findMatchCount(winningNumbers);

        assertThat(matchNumberCount).isEqualTo(4);
    }

    @Test
    @DisplayName("보너스번호의 일치여부를 반환한다.")
    void 보너스번호_일치여부() {
        List<Integer> match = List.of(10, 13, 39, 5, 23, 40);
        List<Integer> notMatch = List.of(10, 13, 39, 5, 23, 42);

        LottoTicket lottoTicket = new LottoTicket(match.stream()
                                                       .map(LottoNumber::new)
                                                       .collect(Collectors.toList()));

        LottoTicket lottoTicket2 = new LottoTicket(notMatch.stream()
                                                           .map(LottoNumber::new)
                                                           .collect(Collectors.toList()));

        lottoTicket.findMatchCount(winningNumbers);
        lottoTicket2.findMatchCount(winningNumbers);

        boolean matchBonus = lottoTicket.getMatchedBonus();
        boolean notMatchBonus = lottoTicket2.getMatchedBonus();

        assertThat(matchBonus).isTrue();
        assertThat(notMatchBonus).isFalse();
    }

    private WinningNumbers getWinningNumbers() {
        return new WinningNumbers(List.of(10, 39, 4, 1, 23, 31),
                                  new LottoNumber(40));
    }
}
