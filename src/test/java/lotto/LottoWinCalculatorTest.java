package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoWinCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 2 3 4 5 6,1", "1 20 3 4 5 6,2", "1 20 30 4 5 6,3", "1 20 30 40 5 6,4"
            , "1 20 30 40 45 6,5", "1 20 30 40 45 10,6"})
    @DisplayName("발급한 로또번호와 당첨번호의 일치하는 갯수를 구하는 테스트")
    public void calculateMatchedCounts(String input, String expected) {
        // given
        LottoWinCalculator lottoWinCalculator = new LottoWinCalculator();
        lottoWinCalculator.addPickedLottoNumbers(new Lotto(
                                    Arrays.asList(input.split(" ")).stream()
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toList())
        ));
        lottoWinCalculator.setWinLottoNumbers(new LottoNumbers(Arrays.asList(1, 10, 20, 30, 40, 45)));

        // when
        List<Integer> matchedCounts = lottoWinCalculator.calculateMatchedCounts();

        // then
        assertThat(matchedCounts.get(0)).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("로또 당첨 케이스를 확인하는 테스트")
    public void findLottoWinPrize() {
        // given
        LottoWinCalculator lottoWinCalculator = new LottoWinCalculator();
        lottoWinCalculator.addPickedLottoNumbers(new Lotto(Arrays.asList(1, 2, 3, 30, 40, 45)));   // prize 4
        lottoWinCalculator.addPickedLottoNumbers(new Lotto(Arrays.asList(1, 10, 20, 30, 40, 45))); // prize 6
        lottoWinCalculator.addPickedLottoNumbers(new Lotto(Arrays.asList(5, 10, 20, 30, 40, 45))); // prize 5
        lottoWinCalculator.setWinLottoNumbers(new LottoNumbers(Arrays.asList(1, 10, 20, 30, 40, 45)));

        List<Integer> expected = Arrays.asList(0, 1, 1, 1);

        // when
        List<LottoWinPrize> lottoWinPrizes = lottoWinCalculator.findLottoWinPrize();

        // then
        int i = 0;
        for (LottoWinPrize lottoWinPrize : lottoWinPrizes) {
            assertThat(lottoWinPrize.getCount()).isEqualTo(expected.get(i++));
        }
    }
}