package step5.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.lotto.Lotto;
import step5.lotto.LottoCount;
import org.junit.jupiter.api.BeforeEach;
import step5.lotto.LottoNumber;
import step5.lotto.LottoTicket;
import step5.utils.ValidationUtils;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    private WinningStatistics statistics;

    @BeforeEach
    void setUp() {
        LottoCount lottoCount = new LottoCount(14000);
        Lotto lotto = new Lotto(lottoCount);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber(3);
        statistics = new WinningStatistics(lotto, winningNumbers, lottoCount, bonusNumber);
    }

    @DisplayName("로또번호 지정하여 당첨 결과 계산")
    @ParameterizedTest
    @CsvSource(value = {"2,4,5,10,11,12:3", "2,3,4,5,6,7:5", "1,2,3,4,5,6:6", "10,11,12,23,34,45:0"}, delimiter = ':')
    void calculateWinningResult(String inputLottoNumber, int expected) {
        Set<Integer> lottoNumbers = ValidationUtils.validWinningNumbers(inputLottoNumber);
        LottoTicket ticket = new LottoTicket(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        int result = statistics.compareNumbers(ticket, winningNumbers);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("보너스번호 당첨 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"2,4,5,10,11,12:false", "1,2,3,4,5,10:false", "1,2,3,4,5,7:true", "1,2,3,4,5,6:false", "10,11,12,23,34,45:false"}, delimiter = ':')
    void hasBonusNumber(String inputLottoNumber, boolean expected) {
        Set<Integer> lottoNumbers = ValidationUtils.validWinningNumbers(inputLottoNumber);
        LottoTicket ticket = new LottoTicket(lottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        int points = statistics.compareNumbers(ticket, winningNumbers);
        boolean result = statistics.hasBonusNumber(points, ticket, bonusNumber);
        assertThat(result).isEqualTo(expected);
    }
}
