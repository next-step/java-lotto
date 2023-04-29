package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinnerStatisticsTest {

    @Test
    @DisplayName("지난주 당첨번호와 구입한 로또를 비교하여 3개이상 일치하는 경우만 기록합니다.")
    void test01() {
        LottoNumber bonusBall = new LottoNumber(30);
        LottoNumbers lastWeekWinnerNumber = LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 6);
        LottoTickets purchasedLottoTickets = new LottoTickets(List.of(
                LottoNumbers.ofTypeIntegers(1, 2, 10, 11, 12, 13),
                LottoNumbers.ofTypeIntegers(1, 2, 3, 10, 11, 12),
                LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 10, 11),
                LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 10),
                LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 30),
                LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 6)
        ));

        WinnerNumbers winnerNumbers = new WinnerNumbers(lastWeekWinnerNumber, bonusBall);
        WinnerStatistics winnerStatistics = winnerNumbers.getWinnerStatistics(purchasedLottoTickets);

        assertAll(
                () -> assertThat(winnerStatistics.getCountByRank(LottoRank.FIFTH)).isOne(),
                () -> assertThat(winnerStatistics.getCountByRank(LottoRank.FOURTH)).isOne(),
                () -> assertThat(winnerStatistics.getCountByRank(LottoRank.THIRD)).isOne(),
                () -> assertThat(winnerStatistics.getCountByRank(LottoRank.SECOND)).isOne(),
                () -> assertThat(winnerStatistics.getCountByRank(LottoRank.FIRST)).isOne()
        );

    }

    @Test
    @DisplayName("지난주 당첨번호와 구입한 로또를 비교하여 소득률을 구합니다.")
    void test02() {
        LottoNumber bonusBall = new LottoNumber(43);
        LottoNumbers lastWeekWinnerNumber = LottoNumbers.ofTypeIntegers(1, 2, 3, 4, 5, 6);
        LottoTickets purchasedLottoTickets = new LottoTickets(List.of(
                LottoNumbers.ofTypeIntegers(1, 2, 3, 10, 22, 45),
                LottoNumbers.ofTypeIntegers(5, 19, 23, 34, 36, 45),
                LottoNumbers.ofTypeIntegers(10, 12, 23, 34, 36, 45),
                LottoNumbers.ofTypeIntegers(15, 16, 28, 29, 35, 38)
        ));

        WinnerNumbers winnerNumbers = new WinnerNumbers(lastWeekWinnerNumber, bonusBall);
        WinnerStatistics winnerStatistics = winnerNumbers.getWinnerStatistics(purchasedLottoTickets);
        double actual = winnerStatistics.getIncomeRate();

        assertThat(actual).isGreaterThan(1.0);
    }

}