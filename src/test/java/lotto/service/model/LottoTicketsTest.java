package lotto.service.model;

import lotto.service.domain.LottoTicket;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.domain.types.Rank;
import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class LottoTicketsTest {
    @Test
    @DisplayName("로또복권들 갯수 검증")
    void getLottoTicketsCount() {
        List<LottoTicket> result = getTestLottoTicket();
        LottoTickets lottoTickets = LottoTickets.from(getTestLottoTicket());
        assertThat(lottoTickets.getCountOfLottoTickets()).isEqualTo(result.size());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1      |true",
            "2      |true",
            "3      |true",
            "4      |true",
            "5      |true",
            "6      |true",
            "7      |false",
            "8      |false",
            "9      |false",
    }, delimiter = '|')
    @DisplayName("보너스볼 포함 여부")
    void isBonusNumberMatch(Integer bonusNumber, boolean expected) {
        LottoTickets lottoTickets = LottoTickets.from(getTestLottoTicket());
        boolean isMatch = lottoTickets.isBonusNumberMatch(getTestWinningLottoTicket(bonusNumber));
        assertThat(isMatch).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] 당첨번호는 {0}, {1}, {2}, {3}, {4}, {5} 이고, 보너스번호는 {6} 일때 등수는 {7} 이다.")
    @CsvSource(value = {
            "1      |2      |3      |4      |5      |6      |7      |FIRST ",
            "11     |2      |3      |4      |5      |6      |1      |SECOND",
            "11     |2      |3      |4      |5      |6      |7      |THIRD",
            "11     |12     |3      |4      |5      |6      |7      |FOURTH",
            "11     |12     |13     |4      |5      |6      |7      |FIFTH",
            "11     |12     |13     |14     |5      |6      |7      |MISS",
            "11     |12     |13     |14     |15     |6      |7      |MISS",
            "11     |12     |13     |14     |15     |16     |7      |MISS",
    }, delimiter = '|')
    @DisplayName("랭킹별 카운트 검증")
    void countOfWinningByRank(Integer number1, Integer number2, Integer number3,
                              Integer number4, Integer number5, Integer number6,
                              Integer bonusNumber,
                              Rank rank) {
        LottoTickets lottoTickets = LottoTickets.from(getTestLottoTicket());
        WinningLottoTicket winningLottoTicket = getTestWinningLottoTicket(number1, number2, number3, number4, number5,
                                                                          number6, bonusNumber);

        Map<Rank, Integer> countOfWinningByRank = lottoTickets.countOfWinningByRank(winningLottoTicket);

        assertThat(countOfWinningByRank.get(rank)).isNotNull().isEqualTo(1);
    }

    @Test
    @DisplayName("로또복권 정보가 없는 경우 예외 발생")
    void exception() {
        assertThatNullPointerException().isThrownBy(() -> LottoTickets.from(null));
    }

    private List<LottoTicket> getTestLottoTicket() {
        List<LottoNumber> numbers = Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                                  LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));

        return Collections.singletonList(LottoTicket.from(numbers));
    }

    private static WinningLottoTicket getTestWinningLottoTicket(Integer bonusNumber) {
        return WinningLottoTicket.of(
                Arrays.asList(LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(13),
                              LottoNumber.from(14), LottoNumber.from(15), LottoNumber.from(16)),
                bonusNumber);
    }

    private static WinningLottoTicket getTestWinningLottoTicket(
            Integer number1, Integer number2, Integer number3, Integer number4, Integer number5, Integer number6,
            Integer bonusNumber) {
        return WinningLottoTicket.of(
                Arrays.asList(LottoNumber.from(number1), LottoNumber.from(number2), LottoNumber.from(number3),
                              LottoNumber.from(number4), LottoNumber.from(number5), LottoNumber.from(number6)),
                bonusNumber);
    }
}
