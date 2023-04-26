package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    @Test
    @DisplayName("지난주 당첨번호와 구입한 로또를 비교하여 3개이상 일치하는 경우만 기록합니다.")
    void test01() {
        LottoWinningNumber lastWeekWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6));
        LottoTickets purchasedLottoTickets = new LottoTickets(List.of(
                new LottoNumbers(1, 3, 5, 14, 22, 45),
                new LottoNumbers(1, 2, 4, 5, 22, 45),
                new LottoNumbers(1, 2, 3, 4, 6, 45),
                new LottoNumbers(5, 9, 38, 41, 43, 44)
        ));

        WinningStatistics winningStatistics = new WinningStatistics(lastWeekWinningNumber, purchasedLottoTickets);
        winningStatistics.calculate();
        long actual = winningStatistics.getDetail()
                .values()
                .stream()
                .filter(v -> v > 0)
                .count();

        assertThat(actual).isSameAs(3L);
    }

    @Test
    @DisplayName("지난주 당첨번호와 구입한 로또를 비교하여 소득률을 구합니다.")
    void test02() {
        LottoWinningNumber lastWeekWinningNumber = new LottoWinningNumber(List.of(1, 2, 3, 4, 5, 6));
        LottoTickets purchasedLottoTickets = new LottoTickets(List.of(
                new LottoNumbers(1, 2, 3, 10, 22, 45),
                new LottoNumbers(5, 19, 23, 34, 36, 45),
                new LottoNumbers(10, 12, 23, 34, 36, 45),
                new LottoNumbers(15, 16, 28, 29, 35, 38)
        ));

        WinningStatistics winningStatistics = new WinningStatistics(lastWeekWinningNumber, purchasedLottoTickets);
        winningStatistics.calculate();
        double actual = winningStatistics.getIncomeRate();

        Assertions.assertThat(actual).isGreaterThan(1.0);
    }

}