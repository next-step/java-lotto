package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningStatisticsTest {

    @Test
    @DisplayName("지난주 당첨번호와 구입한 로또를 비교하여 3개이상 일치하는 경우만 기록합니다.")
    void test01() {
        LottoNumber bonusBall = new LottoNumber(30);
        Lotto lastWeekWinningLotto = Lotto.ofTypeIntegers(1, 2, 3, 4, 5, 6);
        LottoTickets purchasedLottoTickets = new LottoTickets(List.of(
                Lotto.ofTypeIntegers(1, 2, 10, 11, 12, 13),
                Lotto.ofTypeIntegers(1, 2, 3, 10, 11, 12),
                Lotto.ofTypeIntegers(1, 2, 3, 4, 10, 11),
                Lotto.ofTypeIntegers(1, 2, 3, 4, 5, 10),
                Lotto.ofTypeIntegers(1, 2, 3, 4, 5, 30),
                Lotto.ofTypeIntegers(1, 2, 3, 4, 5, 6)
        ));

        WinningLotto winningLotto = new WinningLotto(lastWeekWinningLotto, bonusBall);
        WinningStatistics winningStatistics = winningLotto.getWinningStatistics(purchasedLottoTickets);

        assertAll(
                () -> assertThat(winningStatistics.getCountByRank(LottoRank.FIFTH)).isOne(),
                () -> assertThat(winningStatistics.getCountByRank(LottoRank.FOURTH)).isOne(),
                () -> assertThat(winningStatistics.getCountByRank(LottoRank.THIRD)).isOne(),
                () -> assertThat(winningStatistics.getCountByRank(LottoRank.SECOND)).isOne(),
                () -> assertThat(winningStatistics.getCountByRank(LottoRank.FIRST)).isOne()
        );

    }

    @Test
    @DisplayName("지난주 당첨번호와 구입한 로또를 비교하여 소득률을 구합니다.")
    void test02() {
        LottoNumber bonusBall = new LottoNumber(43);
        Lotto lastWeekWinningNumber = Lotto.ofTypeIntegers(1, 2, 3, 4, 5, 6);
        LottoTickets purchasedLottoTickets = new LottoTickets(List.of(
                Lotto.ofTypeIntegers(1, 2, 3, 10, 22, 45),
                Lotto.ofTypeIntegers(5, 19, 23, 34, 36, 45),
                Lotto.ofTypeIntegers(10, 12, 23, 34, 36, 45),
                Lotto.ofTypeIntegers(15, 16, 28, 29, 35, 38)
        ));

        WinningLotto winningLotto = new WinningLotto(lastWeekWinningNumber, bonusBall);
        WinningStatistics winningStatistics = winningLotto.getWinningStatistics(purchasedLottoTickets);
        double actual = winningStatistics.getIncomeRate();

        assertThat(actual).isGreaterThan(1.0);
    }

}