package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private final List<Integer> integersFixture = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    @DisplayName("Numbers를 받는 생성자로 Lotto를 생성한다.")
    @Test
    void create() {
        assertThat(new Lotto(new Numbers(integersFixture)).getNumbers()).isInstanceOf(Numbers.class);
    }

    @DisplayName("countMatch 함수는 Lotto Numbers 가 prizeNumbers 와 일치하는 수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 6", "2, 5", "3, 4", "4, 3", "5, 2", "6, 1", "7, 0"})
    void countMatch(int number, int expect) {
        List<Integer> prizeNumbers = Arrays.asList(number, number + 1, number + 2, number + 3, number + 4, number + 5);
        assertThat(new Lotto(new Numbers(integersFixture)).countMatch(new Numbers(prizeNumbers))).isEqualTo(expect);
    }
}
