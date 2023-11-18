package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        void 로또_번호_1이상_45이하가_아닐_경우_에러(int lottoNumber) {
                assertThatThrownBy(() -> new LottoNumber(lottoNumber)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("로또 번호는 1 ~ 45 사이의 번호만 가능합니다.");
        }
}
