package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    @Test
    @DisplayName("6개가 아닌 번호로 로또 번호 생성 시 에러 발생")
    public void validate_로또_번호_갯수() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers.of(Arrays.asList(1,2,3));
        });
    }

    @Test
    @DisplayName("번호 비교 후 일치하는 개수를 반환")
    public void 일치하는_숫자_갯수() {
        LottoNumbers numbers1 = LottoNumbers.of(Arrays.asList(1,2,3,4,5,6));
        LottoNumbers numbers2 = LottoNumbers.of(Arrays.asList(3,4,5,6,7,8));
        Assertions.assertThat(numbers1.matchNumbers(numbers2))
                .isEqualTo(4);
    }
}
