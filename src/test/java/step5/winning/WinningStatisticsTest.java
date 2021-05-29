package step5.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.lotto.Lotto;
import step5.lotto.LottoTicket;
import step5.utils.StringUtils;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    @DisplayName("당첨번호와 보너스볼 확인하여 반환 등수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,6:7:FIRST", "1,2,3,4,5,10:1,2,3,4,5,9:10:SECOND",
                        "1,2,3,4,5,7:1,2,3,4,5,8:10:THIRD", "1,2,3,4,5,6:1,2,3,4,10,11:13:FORTH",
                        "10,11,12,23,34,45:10,11,12,33,35,36:37:FIFTH", "1,2,3,4,5,6:11,12,13,14,15,16:17:ZERO"}, delimiter = ':')
    void makeWinningResult(String inputNumbers, String inputWinningNumbers, int bonusNumber, WinningPrize result) {
        //given
        Set<Integer> numbers = StringUtils.processStringNumbers(inputNumbers);
        Lotto lotto = new Lotto(1000, 1);
        lotto.addManualLottoTicket(numbers);

        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, bonusNumber);
        WinningStatistics statistics = new WinningStatistics();
        LottoTicket ticket = lotto.getLottoTickets().get(0);

        //when
        WinningPrize prize = statistics.makeWinningResult(ticket, winningNumbers);

        //then
        assertThat(prize).isEqualTo(result);
    }

    @DisplayName("당첨번호와 보너스볼 확인하여 최종 몇등인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,6:7:FIRST", "1,2,3,4,5,10:1,2,3,4,5,9:10:SECOND",
            "1,2,3,4,5,7:1,2,3,4,5,8:10:THIRD", "1,2,3,4,5,6:1,2,3,4,10,11:13:FORTH",
            "10,11,12,23,34,45:10,11,12,33,35,36:37:FIFTH", "1,2,3,4,5,6:11,12,13,14,15,16:17:ZERO"}, delimiter = ':')
    void calculateWinningResult(String inputNumbers, String inputWinningNumbers, int bonusNumber, String result) {
        //given
        Set<Integer> numbers = StringUtils.processStringNumbers(inputNumbers);
        Lotto lotto = new Lotto(1000, 1);
        lotto.addManualLottoTicket(numbers);

        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, bonusNumber);
        WinningStatistics statistics = new WinningStatistics();

        //when
        statistics.calculateWinningResult(lotto.getLottoTickets(), winningNumbers);

        //then
        Set<WinningPrize> resultSet = new HashSet<>();
        resultSet.add(WinningPrize.valueOf(result));
        assertThat(statistics.getWinningResults().keySet()).isEqualTo(resultSet);
    }

    @DisplayName("수익률 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,6:7:400000.00", "1,2,3,4,5,10:1,2,3,4,5,9:10:6000.00",
            "1,2,3,4,5,7:1,2,3,4,5,8:10:300.00", "1,2,3,4,5,6:1,2,3,4,10,11:13:10.00",
            "10,11,12,23,34,45:10,11,12,33,35,36:37:1.00", "1,2,3,4,5,6:11,12,13,14,15,16:17:0.00"}, delimiter = ':')
    void calculateYield(String inputNumbers, String inputWinningNumbers, int bonusNumber, BigDecimal result) {
        //given
        Set<Integer> numbers = StringUtils.processStringNumbers(inputNumbers);
        Lotto lotto = new Lotto(5000, 1);
        lotto.addManualLottoTicket(numbers);

        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, bonusNumber);
        WinningStatistics statistics = new WinningStatistics();

        //when
        statistics.calculateWinningResult(lotto.getLottoTickets(), winningNumbers);
        statistics.calculateYield(lotto.getPurchasePrice());

        //then
        assertThat(statistics.getYield()).isEqualTo(result);
    }
}
