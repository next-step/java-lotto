package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    void 로또_장당_당첨번호_개수_일치여부_테스트() {
        LottoTickets lottoTickets = new LottoTickets(2000,
            Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10))));
        List<Integer> correctWinNumbers = lottoTickets.countNumberOfMatches(
            new LottoMachine(Arrays.asList(1, 2, 3, 4, 5, 6), 8));
        Assertions.assertThat(correctWinNumbers.get(0)).isEqualTo(6);
        Assertions.assertThat(correctWinNumbers.get(1)).isEqualTo(2);
    }

    @Test
    void 로또_장당_보너스_개수_일치여부_테스트() {
        LottoTickets lottoTickets = new LottoTickets(2000,
            Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10))));
        List<Integer> checkBonusNumber = lottoTickets.checkBonusNumber(
            new LottoMachine(Arrays.asList(1, 2, 3, 4, 5, 6), 8));
        Assertions.assertThat(checkBonusNumber.get(0)).isEqualTo(0);
        Assertions.assertThat(checkBonusNumber.get(1)).isEqualTo(1);
    }
}
