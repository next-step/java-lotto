package lotto;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoWinCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 2 3 4 5 6,1", "1 20 3 4 5 6,2", "1 20 30 4 5 6,3", "1 20 30 40 5 6,4"
            , "1 20 30 40 46 6,5", "1 20 30 40 46 10,6"})
    @DisplayName("발급한 로또번호와 당첨번호의 일치하는 갯수를 구하는 테스트")
    public void calculateMatchedCounts(String input, String expected) {
        // given
        LottoWinCalculator lottoWinCalculator = new LottoWinCalculator();
        lottoWinCalculator.addPickedLottoNumbers(Arrays.asList(input.split(" ")).stream()
                                                .map(Integer::parseInt)
                                                .collect(Collectors.toList()));
        lottoWinCalculator.setWinLottoNumbers(new LottoNumbers(Arrays.asList(1, 10, 20, 30, 40, 46)));

        // when
        List<Integer> matchedCounts = lottoWinCalculator.calculateMatchedCounts();

        // then
        assertThat(matchedCounts.get(0)).isEqualTo(Integer.parseInt(expected));
    }
}