package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.intf.NumbersGenerator;
import lotto.utils.LottoNumbersUtil;
import lotto.constant.LottoRank;

/**
 * 통계를 처리하는 LottoRankStatistics 클래스 기능 테스트
 */
public class LottoRankStatisticsTest {

    @ParameterizedTest
    @CsvSource(value = {"20:1,2,3,40,41,42:0.65:4", "30:4,5,3,40,41,42:0.30:1", "10:5,2,3,4,41,42:8.07:1",
            "20:1,2,3,4,7,10:1371.73:8", "20:1,2,3,4,5,6:88263.04:7"}, delimiter = ':')
    @DisplayName("보너스 번호를 반영한 총 수익률을 확인")
    void rateOfReturn_by_total_winningMoney(int size, String winningNumber, String rateOfReturn, int bonusNumber) {
        // given
        List<String> textLottoNumbers = new ArrayList<>(Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,7", "1,2,3,4,7,8"));
        for (int i = 0; i < size; i++) {
            textLottoNumbers.add("11,12,13,14,17,18");
        }
        List<LottoNumbers> lottos = toLottoNumbers(textLottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(LottoNumbersUtil.toLottoNumbers(winningNumber),
                new LottoNumber(bonusNumber));
        LottoRankStatistics statistics = new LottoRankStatistics(new Lottos(lottos), winningNumbers);

        // when
        String resultRateOfReturn = statistics.calculateRateOfReturn();

        // then
        assertThat(resultRateOfReturn).isEqualTo(rateOfReturn);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1,2,3,4,5,6:7:FIRST", "2:1,2,3,4,5,7:6:SECOND", "3:1,2,3,4,5,7:8:THIRD",
            "5:10,12,13,14,15,17:18:OUT_OF_RANK"}, delimiter = ':')
    @DisplayName("등수별 당첨 개수를 확인")
    void lottoCount_by_rank(int lottoCount, String textWinningNumber, int bonusNumber, LottoRank rank) {
        // given
        NumbersGenerator generator = createLottoNumbers("1,2,3,4,5,6");
        LottoMachine machine = new LottoMachine(new Price(lottoCount * 1000));
        WinningNumbers winningNumbers = new WinningNumbers(LottoNumbersUtil.toLottoNumbers(textWinningNumber),
                new LottoNumber(bonusNumber));
        LottoRankStatistics statistics = new LottoRankStatistics(machine.createLottos(generator), winningNumbers);

        // when
        int resultLottoCount = statistics.getLottoCountByRank(rank);

        // then
        assertThat(resultLottoCount).isEqualTo(lottoCount);
    }

    private NumbersGenerator createLottoNumbers(String textNumber) {
        return () -> LottoNumbersUtil.toLottoNumbers(textNumber);
    }

    private List<LottoNumbers> toLottoNumbers(List<String> textLottoNumbers) {
        return textLottoNumbers.stream().map(LottoNumbersUtil::toLottoNumbers).collect(Collectors.toList());
    }
}
