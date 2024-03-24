package lotto.numberdrawer;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ShuffledNumberDrawerTest {

    @Test
    @DisplayName("1부터 BOUND 사이의 숫자 6개를 반환")
    void drawnNumbers() {
        ShuffledNumberDrawer numberDrawer = new ShuffledNumberDrawer();
        int bound = 45;
        int size = 6;
        List<LottoNumber> numbers = numberDrawer.drawnNumbers(bound, size);

        assertThat(numbers).hasSize(size);
        assertThat(numbers).allMatch(
                (number) -> number.compareTo(LottoNumber.valueOf(0)) > 0
                        && number.compareTo(LottoNumber.valueOf(bound)) < 0);
    }
}