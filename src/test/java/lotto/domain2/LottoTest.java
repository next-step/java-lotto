package lotto.domain2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 생성() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 로또번호_개수_부족하거나_많을때(final String input) {
        String[] inputSplit = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputSplit) {
            numbers.add(Integer.parseInt(number));
        }

        assertThatThrownBy(() -> {
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
