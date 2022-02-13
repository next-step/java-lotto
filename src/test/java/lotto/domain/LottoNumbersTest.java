package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    void 복권의_숫자_개수는_6개여야_한다() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> Lotto.of(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("복권의 숫자 개수가 유효하지 않습니다.");
    }

    @Test
    void 복권의_숫자는_중복될_수_없다() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> Lotto.of(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("복권에 중복된 숫자가 존재합니다.");
    }
}
