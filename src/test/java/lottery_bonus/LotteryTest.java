package lottery_bonus;

import lottery_bonus.domain.Lottery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    private Lottery lottery;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        lottery = new Lottery(winningNumbers);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6;6", "7,8,9,10,11,12;0"}, delimiterString = ";")
    @DisplayName("로또 일치하는 횟수 카운트")
    void compareWinningNumber(String numberList, int expectedValue) {
        String[] numberArray = numberList.split(",");
        List<Integer> quickpicks = Arrays.stream(numberArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertThat(lottery.compareWinningNumber(quickpicks)).isEqualTo(expectedValue);
    }
    @ParameterizedTest
    @CsvSource(value = {"1;true", "7;false"}, delimiterString = ";")
    @DisplayName("로또 보너스 볼 일치 테스트")
    void compareBonusNumber(int bonusNumber, boolean expectedValue) {
        assertThat(lottery.compareBonusNumber(bonusNumber)).isEqualTo(expectedValue);
    }

}