package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumbersTest {

        @Test
        void 로또_번호_중복_제거_후_6개_아닐_시_에러() {
                assertThatThrownBy(() -> new LottoNumbers(1, 1, 2, 3, 4, 5)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("로또는 6개의 번호를 가져야 합니다.");
        }
}
