package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberFactoryTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호가_1에서_45사이_값이_아니면_예외를_던진다(int given) {
        assertThatThrownBy(() -> LottoNumberFactory.of(given))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 중복번호를_입력할_예외를_반환한다() {
        assertThatThrownBy(() -> LottoNumberFactory.of(1, 1, 1, 1, 1, 2))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage("중복을 제외한 6개의 로또 번호가 필요합니다");
    }
}
