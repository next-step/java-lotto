package lotto;

import lotto.domain.LottoNumbers;
import lotto.infra.RandomNumberGenerator;
import lotto.utils.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @ParameterizedTest
    @DisplayName("잘못된 경우 입력했을 경우 테스트(6글자가 아니거나 중복된 숫자가 있거나 1~45 범위를 벗어난 경우)")
    @MethodSource("getInvalidLottoNumbers")
    void testInvalidLotto(List<Integer> invalidLottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(new TestNumberGenerator(invalidLottoNumbers)));
    }

    @ParameterizedTest
    @DisplayName("1~45 사이 중복되지 않은 숫자 6개 생성하는 경우 테스트")
    @MethodSource("getValidLottoNumbers")
    void testValidLotto(List<Integer> validLottoNumbers) {
        LottoNumbers lottoNumbers = new LottoNumbers(new TestNumberGenerator(validLottoNumbers));
        assertThat(lottoNumbers.getNumbers()).hasSize(6).containsExactlyElementsOf(validLottoNumbers);
    }

    @Test
    @DisplayName("랜덤으로 로또 생성할 시, 예외 발생하는 지 테스트(항상 올바른 결과 나오지 않을 수 있음!)")
    void testRandomLotto() {
        assertThat(new LottoNumbers(new RandomNumberGenerator()).getNumbers()).hasSize(LottoNumbers.NUMBER_LEN);
    }

    private static List<List<Integer>> getInvalidLottoNumbers() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1, -1, 3, 5, 6, 7));
        result.add(List.of(1, 1, 2, 3, 4, 5));
        result.add(List.of(5, 1, 2, 16, 3));
        result.add(List.of(13, 15, 46, 1, 2, 23));
        result.add(List.of());
        result.add(null);

        return result;
    }

    private static List<List<Integer>> getValidLottoNumbers() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 10, 45, 1, 30, 5),
                List.of(42, 1, 10, 24, 34, 40)
        );
    }

}
