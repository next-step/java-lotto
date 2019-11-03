package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 생성() {
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,8,9,10:3", "1,2,3,4,9,10:4", "1,2,3,4,5,10:5", "1,2,3,4,5,6:6"}, delimiter = ':')
    void 당첨여부확인(final String input, final int expected) {
        String[] numbers = input.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (String number : numbers) {
            winNumbers.add(Integer.parseInt(number));
        }
        int result = lotto.findMatchedNumberCount(winNumbers);
        assertThat(result).isEqualTo(expected);
    }
}
