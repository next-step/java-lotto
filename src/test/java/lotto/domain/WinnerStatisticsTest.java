package lotto.domain;

import lotto.utils.LottoLotteryUtils;
import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerStatisticsTest {

    List<LottoTicket> tickets = new ArrayList<>();

    @BeforeEach
    public void initLottoTicket() {

        for (int i = 0; i < 5; i++) {
            List<LottoNumber> lottoNumbers = makeLottoNumbers(6 * i + 1);
            tickets.add(LottoTicket.create(lottoNumbers));
        }
    }

    private List<LottoNumber> makeLottoNumbers(int startNumber) {
        List<String> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String number = String.valueOf(startNumber + i);
            lottoNumbers.add(number);
        }
        return LottoNumberGenerator.manualGenerator(lottoNumbers);
    }

    @DisplayName("로또당첨등수별 수익률 테스트(5장구입기준)")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:400000.00", "1,2,3,4,5,40:300.00", "1,2,3,4,35,40:10.00", "1,2,3,30,35,40:1.00", "1,2,25,30,35,40:0.00"}, delimiter = ':')
    public void incomeRateTest(String lottoNumber, String expectedRate) {
        String[] splitedLottoNumber = StringUtils.split(lottoNumber);

        List<String> lottoNumberText = Arrays.asList(splitedLottoNumber);
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.manualGenerator(lottoNumberText);
        WinnerNumbers winnerNumbers = WinnerNumbers.create(lottoNumbers);

        WinnerStatistics winnerStatistics = LottoLotteryUtils.lotteryThisWeek(tickets, winnerNumbers);

        assertThat(winnerStatistics.incomeRate()).isEqualTo(expectedRate);
    }
}
