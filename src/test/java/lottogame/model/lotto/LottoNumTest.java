package lottogame.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또번호가_1미만이거나_45를초과하면_예외처리를_할_수_있다(int num) {
        assertThatThrownBy(
                () -> LottoNum.of(num)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수형인_로또번호_Set을_LottoNum_Set으로_변환할_수_있다() {
        Assertions.assertThat(
                LottoNum.convertToBundle(Set.of(1,2,3,4,5,6))
        ).contains(
                LottoNum.of(1),
                LottoNum.of(2),
                LottoNum.of(3),
                LottoNum.of(4),
                LottoNum.of(5),
                LottoNum.of(6)
        );
    }


}