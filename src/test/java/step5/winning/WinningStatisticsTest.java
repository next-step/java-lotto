package step5.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import step5.lotto.LottoTicket;
import step5.utils.StringUtils;

import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    private WinningStatistics statistics;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(14000);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 10);
        statistics = new WinningStatistics(lotto, winningNumbers);
    }

    @DisplayName("로또번호 지정하여 당첨 결과 계산")
    @ParameterizedTest
    @CsvSource(value = {"2,4,5,10,11,12:3", "2,3,4,5,6,7:5", "1,2,3,4,5,6:6", "10,11,12,23,34,45:0"}, delimiter = ':')
    void calculateWinningResult(String inputLottoNumber, int expected) {
        Set<Integer> lottoNumbers = StringUtils.processStringNumbers(inputLottoNumber);
        LottoTicket ticket = new LottoTicket(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 11);

        int result = statistics.compareNumbers(ticket, winningNumbers);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("보너스번호 당첨 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"2,4,5,10,11,12:true", "1,2,3,4,5,10:true", "1,2,3,4,5,7:false", "1,2,3,4,5,6:false", "10,11,12,23,34,45:true"}, delimiter = ':')
    void hasBonusNumber(String inputLottoNumber, boolean expected) {
        Set<Integer> lottoNumbers = StringUtils.processStringNumbers(inputLottoNumber);
        LottoTicket ticket = new LottoTicket(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 10);
        boolean result = statistics.hasBonusNumber(ticket, winningNumbers.getBonusNumber());
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("당첨번호와 보너스볼 확인한 최종 몇등에 당첨됬는지에 대한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,6:7:1", "1,2,3,4,5,10:1,2,3,4,5,9:10:2",
                        "1,2,3,4,5,7:1,2,3,4,5,8:10:3", "1,2,3,4,5,6:1,2,3,4,10,11:13:4",
                        "10,11,12,23,34,45:10,11,12,33,35,36:37:5", "1,2,3,4,5,6:11,12,13,14,15,16:17:6"}, delimiter = ':')
    void makeWinningResult(String inputNumbers, String inputWinningNumbers, int bonusNumber, int result) {
        Set<Integer> numbers = StringUtils.processStringNumbers(inputNumbers);
        LottoTicket lottoTicket = new LottoTicket(numbers);
        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, bonusNumber);
        WinningPrize prize = statistics.makeWinningResult(lottoTicket, winningNumbers);
        assertThat(prize.getWinningPrize()).isEqualTo(result);
    }
}
