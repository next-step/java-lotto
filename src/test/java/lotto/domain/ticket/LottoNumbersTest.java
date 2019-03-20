package lotto.domain.ticket;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    @Test
    public void 로또_숫자의_수가_6개가_넘어가면_IllegalArgumentException() {
        // given
        List<Integer> fiveNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sixNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> sevenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(fiveNumbers));
        new LottoNumbers(sixNumbers);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(sevenNumbers));
    }

    @Test
    public void 서로_겹치는_숫자_갯수_구하기() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers six = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers zero = new LottoNumbers(Arrays.asList(11, 12, 13, 14, 15, 16));

        // when
        int shouldBeSix = lottoNumbers.getNumberOfDuplicatedNumbers(six);
        int shouldBeZero = lottoNumbers.getNumberOfDuplicatedNumbers(zero);

        // then
        assertThat(shouldBeSix).isEqualTo(6);
        assertThat(shouldBeZero).isEqualTo(0);
    }
}
