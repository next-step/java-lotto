package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class LottosTest {

    @ParameterizedTest
    @CsvSource({
            "21, 2, 3, 8, 9, 10, FIFTH, 1",
            "21, 2, 3, 41, 9, 10, FOURTH, 1",
            "21, 2, 3, 41, 5, 10, SECOND, 1",
            "21, 2, 3, 41, 5, 43, FIRST, 1"
    })
    @DisplayName("당첨 통계 테스트 - 1,2,3,4,5등 검증")
    void winningStatisticsTest(int number1, int number2, int number3, int number4, int number5, int number6, String key, int expectedMatchCount) {
        List<Integer> lottoNumbers = List.of(number1, number2, number3, number4, number5, number6);
        List<Integer> winningLottoNumber = List.of(21, 2, 3, 41, 5, 43);

        List<LottoNumbers> inputLottos = List.of(new LottoNumbers(lottoNumbers));
        Lottos lottos = new Lottos(inputLottos);

        Map<LottoRank, Integer> lottoRanks = lottos.getWinningStatistics(new LottoNumbers(winningLottoNumber));
        LottoRank expectedRank = LottoRank.valueOf(key);

        assertThat(lottoRanks.get(expectedRank)).isEqualTo(expectedMatchCount);
    }

}
