package lotto;

import lotto.domain.LottoMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoMatchingServiceTest {

    @DisplayName("당첨 번호를 입력하면 일치하는 갯수를 담은 리스트(3개,4개,5개,6개)를 반환한다")
    @Test
    void match_winning_number() {
        LottoMatchingService lottoMatchingService = new LottoMatchingService();
        LottoMachine lottoMachine = new LottoMachine(14);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> numberOfWins = lottoMatchingService.matchWinningNumber(lottoMachine, winningNumbers);

        Assertions.assertThat(numberOfWins.size()).isEqualTo(4);
    }

}
