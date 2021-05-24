package step3.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.lotto.Lotto;
import step3.lotto.LottoCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.lotto.LottoTicket;
import step3.utils.ValidationUtils;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    private WinningStatistics statistics;

    @BeforeEach
    void setUp() {
        LottoCount lottoCount = new LottoCount(14000);
        Lotto lotto = new Lotto(lottoCount);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        statistics = new WinningStatistics(lotto, winningNumbers, lottoCount);
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
}
