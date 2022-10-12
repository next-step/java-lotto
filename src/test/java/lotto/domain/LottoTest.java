package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 발급 검증")
    void issueLotto() {
        Lotto lotto = new Lotto();
        lotto.issue(new Payment(10000));
        assertThat(lotto.lottoTickets().size()).isEqualTo(10);
    }

    @RepeatedTest(100)
    @DisplayName("발급 로또 티켓, 당첨 티켓 비교")
    void matchingCountsByTickets() {
        Lotto lotto = new Lotto();
        lotto.issue(new Payment(1000));

        WinningNumber winningNumber = new WinningNumber(new LottoTicket(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        List<Integer> matchingCounts = lotto.matchingCountsByTickets(winningNumber.winningNumber());

        assertThat(matchingCounts).hasSize(1);
        assertThat(matchingCounts.get(0)).isLessThanOrEqualTo(6);
        assertThat(matchingCounts.get(0)).isGreaterThanOrEqualTo(0);
    }

    @RepeatedTest(100)
    @DisplayName("발급 로또 티켓, 당첨 티켓 비교 예외 - 로또 미발급")
    void matchingCountsByTicketsException() {
        Lotto lotto = new Lotto();
        lotto.issue(new Payment(10000));
        WinningNumber winningNumber = new WinningNumber(new LottoTicket(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))));

        assertThatThrownBy(() -> lotto.matchingCountsByTickets(winningNumber.winningNumber()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
