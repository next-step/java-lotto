package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    public void 생성_시_로또_숫자의_수가_6개가_넘어가면_IllegalArgumentException() {
        // given
        List<LottoNumber> fiveNumbers = getLottoNumbers(1, 2, 3, 4, 5);
        List<LottoNumber> sixNumbers = getLottoNumbers(1, 2, 3, 4, 5, 6);
        List<LottoNumber> sevenNumbers = getLottoNumbers(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(fiveNumbers));
        new Lotto(sixNumbers);
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(sevenNumbers));
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
    public void 서로_겹치는_숫자_갯수_구하기() {
        // given
        Lotto lottoNumbers = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto six = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto zero = new Lotto(getLottoNumbers(11, 12, 13, 14, 15, 16));

        // when
        int shouldBeSix = lottoNumbers.getNumberOfDuplicatedNumbers(six);
        int shouldBeZero = lottoNumbers.getNumberOfDuplicatedNumbers(zero);

        // then
        assertThat(shouldBeSix).isEqualTo(6);
        assertThat(shouldBeZero).isEqualTo(0);
    }

    private List<LottoNumber> getLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }
}
