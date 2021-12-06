package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.StringUtils.parseNumbers;

public class LottoTest {

    @DisplayName("Test matching number count with winning number")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:8,9,10,11,12,13:0",
            "1,2,3,4,5,6:1,9,10,11,12,13:1",
            "1,2,3,4,5,6:1,2,10,11,12,13:2",
            "1,2,3,4,5,6:1,2,3,11,12,13:3",
            "1,2,3,4,5,6:1,2,3,4,12,13:4",
            "1,2,3,4,5,6:1,2,3,4,5,13:5",
            "1,2,3,4,5,6:1,2,3,4,5,6:6",
    }, delimiter = ':')
    void testMatchingNumberCount(String input, String winning, int expected) {
        List<Integer> lottoNumbers = parseNumbers(input);
        Lotto lotto = Lotto.of(lottoNumbers);
        List<Integer> winningNumbers = parseNumbers(winning);
        Lotto winningLotto = Lotto.of(winningNumbers);
        int res = lotto.matchingNumberCount(winningLotto);
        assertThat(res).isEqualTo(expected);
    }

    @DisplayName("Test when the number of lotto numbers is not 6")
    @Test
    void testWhenTheNumberOfLottoNumbersIsNotSix() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5);

        assertThatThrownBy(() -> Lotto.of(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
