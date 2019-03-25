package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    public void 생성_시_로또_숫자의_수가_6개_초과면_IllegalArgumentException() {
        // given
        List<LottoNumber> sevenNumbers = getLottoNumbers(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(sevenNumbers));
    }

    @Test
    public void 생성_시_로또_숫자의_수가_6개_미만이면_IllegalArgumentException() {
        // given
        List<LottoNumber> fiveNumbers = getLottoNumbers(1, 2, 3, 4, 5);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(fiveNumbers));
    }

    @Test
    public void 생성_시_로또_숫자간의_중복이_생기면_IllegalArgumentException() {
        // given
        List<LottoNumber> duplicatedNumbers = getLottoNumbers(1, 2, 3, 4, 5, 5);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(duplicatedNumbers));
    }

    @Test
    public void 로또_숫자가_모두_겹치는_경우_겹치는_수_구하기() {
        // given
        Lotto lottoNumbers = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto six = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));

        // when
        int shouldBeSix = lottoNumbers.getNumberOfDuplicatedNumbers(six);

        // then
        assertThat(shouldBeSix).isEqualTo(6);
    }

    @Test
    public void 로또_숫자가_겹치지_않는_경우_겹치는_수_구하기() {
        // given
        Lotto lottoNumbers = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto zero = new Lotto(getLottoNumbers(11, 12, 13, 14, 15, 16));

        // when
        int shouldBeZero = lottoNumbers.getNumberOfDuplicatedNumbers(zero);

        // then
        assertThat(shouldBeZero).isEqualTo(0);
    }

    private List<LottoNumber> getLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }
}
