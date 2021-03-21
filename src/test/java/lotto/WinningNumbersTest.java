package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 당첨 번호 생성")
    public void create() throws Exception {
        List<Integer> numbers = IntStream.range(1, 7).boxed().collect(Collectors.toList());
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(numbers));
    }
}
