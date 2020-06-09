package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private List<Integer> numbers;
    private String[] winningNumbers;

    @BeforeEach
    void setup() {
        int[] intNumbers = {1, 10, 30, 33, 40, 45};
        numbers = Arrays.stream(intNumbers).boxed().collect(Collectors.toList());

        winningNumbers = new String[]{"1","12","30","33","35","41"};
    }

    @Test
    @DisplayName("당첨번호와 비교")
    void matches() {
        Lotto lotto = new Lotto(numbers);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, new LottoNumber(2));

        int count = lotto.matches(winningNumber.getWinningNumbers());

        assertThat(count).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"10,true", "11,false"})
    @DisplayName("보너스볼이 포함하는지 확인")
    void isContainBonus(int bonusball, boolean expected) {
        Lotto lotto = new Lotto(numbers);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, new LottoNumber(bonusball));

        boolean result = lotto.isContainBonus(winningNumber.getBonusNumber());
        assertThat(result).isEqualTo(expected);
    }
}
