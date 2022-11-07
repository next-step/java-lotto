package lotto.numbers;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.numbers.AllNumbers;

public class AllNumbersTest {
    @Test
    public void getNumbers() {
        List<Integer> allNumbers = AllNumbers.getNumbers();
        assertThat(allNumbers.isEmpty()).isEqualTo(false);
        assertThat(allNumbers.size()).isEqualTo(AllNumbers.LAST_NUMBER);
    }
}
