package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.StringUtils.parseNumbers;

public class LottoTest {

    @DisplayName("Test winning condition of Lotto")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,11,12,13:6:FIFTH",
            "1,2,3,4,5,6:1,2,3,4,12,13:6:FOURTH",
            "1,2,3,4,5,6:1,2,3,4,5,13:7:THIRD",
            "1,2,3,4,5,6:1,2,3,4,5,13:6:SECOND",
            "1,2,3,4,5,6:1,2,3,4,5,6:7:FIRST",
    }, delimiter = ':')
    void testWinningCondition(String input, String winning, int bonusNumber, String expected) {
        List<Integer> lottoNumbers = parseNumbers(input);
        Lotto lotto = Lotto.of(lottoNumbers);
        List<Integer> winningNumbers = parseNumbers(winning);
        Lotto winningLotto = Lotto.of(winningNumbers);
        Optional<PrizeCondition> prizeCondition = lotto.prizeCondition(winningLotto, new LottoNumber(bonusNumber));
        prizeCondition.ifPresent( condition -> assertThat(condition).isEqualTo(PrizeCondition.valueOf(expected)));
    }

    @DisplayName("Test losing condition of Lotto")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:8,9,10,11,12,13:6",
            "1,2,3,4,5,6:1,9,10,11,12,13:6",
            "1,2,3,4,5,6:1,2,10,11,12,13:6"
    }, delimiter = ':')
    void testLosingCondition(String input, String winning, int bonusNumber) {
        List<Integer> lottoNumbers = parseNumbers(input);
        Lotto lotto = Lotto.of(lottoNumbers);
        List<Integer> winningNumbers = parseNumbers(winning);
        Lotto winningLotto = Lotto.of(winningNumbers);
        Optional<PrizeCondition> prizeCondition = lotto.prizeCondition(winningLotto, new LottoNumber(bonusNumber));
        assertThat(prizeCondition.isPresent()).isFalse();
    }

    @DisplayName("Test when the number of lotto numbers is not 6")
    @Test
    void testWhenTheNumberOfLottoNumbersIsNotSix() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5);

        assertThatThrownBy(() -> Lotto.of(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
