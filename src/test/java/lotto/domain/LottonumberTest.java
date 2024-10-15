package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottonumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 45})
    void 로또번호는_1에서_45사이이다(int number) {
        Lottonumber lottonumber = new Lottonumber(number);

        assertThat(lottonumber.toString()).hasToString(String.valueOf(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호는_1미만_45초과일_수_없다(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottonumber(number))
                .withMessage("1 ~ 45 사이의 숫자만 사용할 수 있습니다.");
    }
}
