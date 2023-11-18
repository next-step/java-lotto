package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoNumberTest {

    @Test
    void 숫자_범위_테스트() {
        List<Integer> numberOver = Arrays.asList(1, 2, 3, 4, 5, 46);
        List<Integer> numberUnder = Arrays.asList(0, 2, 3, 4, 5, 6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(numberOver));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(numberUnder));
    }

    @Test
    void 숫자_갯수_테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(numbers));
    }
}