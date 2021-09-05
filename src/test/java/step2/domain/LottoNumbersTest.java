package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    void createLottoNumbersDuplicateExceptionTest() {
        assertThatThrownBy(() -> new LottoNumbers(() -> 1))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("로또 숫자 생성 시간이 초과되었습니다.");
    }

    @Test
    void createLottoNumbersSuccessTest() {
        final LottoNumbers actual = new LottoNumbers(
                new LottoNumberGenerationStrategy() {
                    List<Integer> range = Arrays.asList(1, 2, 3, 4, 5, 6);

                    @Override
                    public int generateNumber() {
                        Collections.shuffle(range);
                        return range.get(0);
                    }
                }
        );
        final LottoNumbers expected = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void createLottoNumbersFailTest() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 1, 1, 1, 1, 1, 1)))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("로또 숫자는 6개여야 입니다.");
    }

    @Test
    void createLottoNumbersFail2Test() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 1, 1, 1, 1)))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("로또 숫자는 6개여야 입니다.");
    }
}
