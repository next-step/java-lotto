package application;

import domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticServiceTest {

    StatisticService mockStatisticService;

    LottoTicket mockLottoTicket;
    List<Integer> mockWinningNumbers;
    List<Integer> mockLottoNumbers;

    @DisplayName("구매한 로또와 지난주 우승 번호와 매칭되는 개수 반환")
    @Test
    void getNumberOfMatches() {
        mockStatisticService = new StatisticService();

        mockLottoNumbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        mockWinningNumbers = new LinkedList<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        mockLottoTicket = new LottoTicket(mockLottoNumbers);

        assertThat(mockStatisticService.getNumberOfMatches(mockLottoTicket, mockWinningNumbers))
                .isEqualTo(3);
    }
}