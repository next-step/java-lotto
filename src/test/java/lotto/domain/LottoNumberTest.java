package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    void create() {
        LottoNumber lottoNumber = LottoNumber.of(3);
        assertThat(LottoNumber.of(3)).isEqualTo(lottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_숫자_범위_벗어난_경우(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(number))
                .withMessageMatching("로또는 1~45 사이의 값이어야 합니다.");
    }
}
