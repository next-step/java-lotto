package lotto.domain.ticket;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    public void 생성_시_숫자_범위_넘어갈_경우_IllegalArgumentException() {
        // given
        int underMinNumber = LottoNumber.MIN_NUMBER - 1;
        int overMaxNumber = LottoNumber.MAX_NUMBER + 1;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(underMinNumber));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(overMaxNumber));
    }

    @Test
    public void equalsTo_테스트() {
        // given
        LottoNumber target = new LottoNumber(1);
        LottoNumber same = new LottoNumber(1);
        LottoNumber different = new LottoNumber(2);

        // when
        boolean shouldBeTrue = target.isEqualTo(same);
        boolean shouldBeFalse = target.isEqualTo(different);

        // then
        assertThat(shouldBeTrue).isTrue();
        assertThat(shouldBeFalse).isFalse();
    }
}
