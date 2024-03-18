package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @ParameterizedTest
    @DisplayName("잘못된 경우 입력했을 경우 테스트(6글자가 아니거나 중복된 숫자가 있거나 1~45 범위를 벗어난 경우)")
    @MethodSource("getInvalidLottoNumbers")
    void testInvalidLotto(List<Integer> invalidLottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(invalidLottoNumbers));
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
}
