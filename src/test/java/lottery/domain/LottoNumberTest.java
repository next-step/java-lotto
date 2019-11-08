package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void 로또_번호_범위밖_번호로_생성테스트(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber.of(number);
        }).withMessage("올바르지 못한 로또 번호입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 41, 42, 43, 44, 45})
    void 정상_로또번호_생성테스트(int number) {
        assertThat(LottoNumber.of(number).toString()).isEqualTo(String.valueOf(number));
    }

    @Test
    void 리스트로_로또번호_생성테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(LottoNumber.ofNumbers(numbers).size()).isEqualTo(numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 41, 42, 43, 44, 45})
    void 랜덤_로또번호_생성테스트(int number) {
        assertThat(LottoNumber.ofRandom(number).size()).isEqualTo(number);
    }
}
