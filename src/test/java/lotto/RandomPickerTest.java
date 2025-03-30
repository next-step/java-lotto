package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class RandomPickerTest {

    @Test
    @DisplayName("randomPicker는 random을 통해서 입력받은 count만큼 숫자를 픽해준다.")
    void randomPickerTest() {
        var random = new Random(4);
        var randomPicker = new RandomPicker(random);
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var count = 6;

        var result = randomPicker.pickNumbers(count, numbers);

        Assertions.assertThat(result).hasSize(count)
                .doesNotHaveDuplicates()
                .allMatch(numbers::contains);
    }
}