package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoStatisticsTest {

    @ParameterizedTest(name = "[{index}] {0}개 일치 - {1}개")
    @CsvSource(value = {"3:1", "4:1", "5:1"}, delimiter = ':')
    @DisplayName("[성공] 3개 당첨 1개, 4개 당첨 1개, 5개 당첨 1개에 대한 통계를 구한다.")
    void 당첨_통계_1(int matchCount, int count) {
        // Given
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new LottoTicket(new LottoNumbers(List.of(1, 2, 42, 43, 44, 45))),
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 43, 44, 45))),
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 44, 45))),
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 45))),
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)))
        ));
        LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        LottoNumber bonusNumber = LottoNumber.of(23);

        // When
        LottoStatistics lottoStatistics = new LottoStatistics(new WinLotto(winLottoTicket, bonusNumber), lottoTickets);

        // Then
        assertThat(lottoStatistics.getRankCount(Rank.valueOf(matchCount, false))).isEqualTo(count);
    }

    @ParameterizedTest(name = "[{index}] {0}개 일치 - {1}개")
    @CsvSource(value = {"3:3", "4:2", "6:1"}, delimiter = ':')
    @DisplayName("[성공] 3개 당첨 3개, 4개 당첨 2개, 6개 당첨 1개에 대한 통계를 구한다.")
    void 당첨_통계_2(int matchCount, int count) {
        // Given
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 43, 44, 45))),
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 43, 44, 45))),
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 43, 44, 45))),
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 44, 45))),
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 44, 45))),
                new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)))
        ));
        LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        LottoNumber bonusNumber = LottoNumber.of(23);

        // When
        LottoStatistics lottoStatistics = new LottoStatistics(new WinLotto(winLottoTicket, bonusNumber), lottoTickets);

        // Then
        assertThat(lottoStatistics.getRankCount(Rank.valueOf(matchCount, false))).isEqualTo(count);
    }


}
