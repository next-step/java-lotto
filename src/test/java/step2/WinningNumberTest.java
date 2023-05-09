package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.Number;
import step2.domain.WinningNumber;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    List<Number> numbers;
    WinningNumber winningNumber;

    @BeforeEach
    void init() {
        numbers = Arrays.asList(
                Number.of(1),
                Number.of(2),
                Number.of(3),
                Number.of(4),
                Number.of(5),
                Number.of(6)
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        winningNumber = WinningNumber.generate(winningNumbers, bonusNumber);
    }

    @Test
    void 구매번호와_당첨번호가_일치하는_개수_반환() {
        int result = winningNumber.countWithPurchaseNumber(numbers);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 구매번호에_보너스번호가_포함되어있는지_여부_반환() {
        boolean result = winningNumber.containBonusNumber(numbers);
        assertThat(result).isTrue();

    }
}
