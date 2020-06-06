package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private List<Integer> numbers;
    private List<Integer> winningNumbers;

    @BeforeEach
    void setup() {
        int[] intNumbers = {1, 10, 30, 33, 40, 45};
        numbers = Arrays.stream(intNumbers).boxed().collect(Collectors.toList());

        int[] intWinningNumbers = {1, 12, 30, 33, 35, 41};
        winningNumbers = Arrays.stream(intWinningNumbers).boxed().collect(Collectors.toList());
    }

    @Test
    @DisplayName("당첨번호와 비교")
    void matches() {
        Lotto lotto = new Lotto(numbers);

        int count = lotto.matches(winningNumbers);

        assertThat(count).isEqualTo(3);
    }
}
