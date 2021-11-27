package lotto.domain;

import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.fixture.LottoTicketFixture.LOTTO_TICKETS;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("당첨결과를 반환한다.")
    @Test
    void createResultMap() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        WinningNumbers winningNumbers = WinningNumbers.of(numbers);
        Map<Rank, Integer> result = LOTTO_TICKETS.creatWinningRank(winningNumbers);

        Assertions.assertAll(
                () -> assertThat(result.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(result.get(Rank.FOURTH)).isEqualTo(1)
        );
    }

}
