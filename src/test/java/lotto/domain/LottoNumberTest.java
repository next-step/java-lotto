package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
    public void LottoNumber_get_메서드는_같은_LottoNumber_객체_사용() {
        // given
        int lottoNumber = LottoNumber.MAX_NUMBER;

        // when
        LottoNumber target = LottoNumber.getInstance(lottoNumber);
        LottoNumber same = LottoNumber.getInstance(lottoNumber);

        // then
        assertThat(target == same).isTrue();
    }

    @Test
    public void 로또_숫자_범위를_넘어가는_수를_가져오려고_하면_IllegalArgumentException() {
        int underMinNumber = LottoNumber.MIN_NUMBER - 1;
        int overMaxNumber = LottoNumber.MAX_NUMBER + 1;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.getInstance(underMinNumber));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.getInstance(overMaxNumber));
    }

    @Test
    public void sort_동작_확인() {
        // given
        LottoNumber two = new LottoNumber(2);
        LottoNumber four = new LottoNumber(4);
        LottoNumber one = new LottoNumber(1);

        List<LottoNumber> lottoNumbers = Arrays.asList(two, four, one);

        // when
        lottoNumbers.sort(Comparator.naturalOrder());

        // then
        assertThat(lottoNumbers.get(0)).isEqualByComparingTo(one);
        assertThat(lottoNumbers.get(1)).isEqualByComparingTo(two);
        assertThat(lottoNumbers.get(2)).isEqualByComparingTo(four);
    }
}
