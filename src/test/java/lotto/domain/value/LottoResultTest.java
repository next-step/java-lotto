package lotto.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.fixture.LottoTicketFixture.LOTTO_TICKETS;
import static lotto.fixture.LottoTicketFixture.PROFIT_RATE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("로또 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = WinningNumbers.of(numbers);

        // when
        Map<Rank, Integer> rankIntegerMap = LOTTO_TICKETS.creatWinningRank(winningNumbers);
        LottoResult lottoResult = LottoResult.of(rankIntegerMap, LOTTO_TICKETS.size());

        // then
        assertThat(lottoResult.getProfitRate()).isEqualTo(PROFIT_RATE);
    }

}
