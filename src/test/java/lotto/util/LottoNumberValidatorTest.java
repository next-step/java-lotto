package lotto.util;

import lotto.domain.ticket.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberValidatorTest {
    @Test
    public void 중복되는_숫자가_있는지_확인() {
        // given
        List<Integer> unique = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> duplicated = Arrays.asList(1, 1, 2, 3, 4, 5);

        // when
        // then
        Assertions.assertThat(LottoNumberValidator.isLottoNumbersUnique(unique)).isTrue();
        assertThat(LottoNumberValidator.isLottoNumbersUnique(duplicated)).isFalse();
    }

    @Test
    public void 리스트의_사이즈가_6인지_확인() {
        // given
        List<Integer> five = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> six = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> seven = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThat(LottoNumberValidator.isLottoNumbersSizeCorrect(five)).isFalse();
        assertThat(LottoNumberValidator.isLottoNumbersSizeCorrect(six)).isTrue();
        assertThat(LottoNumberValidator.isLottoNumbersSizeCorrect(seven)).isFalse();
    }

    @Test
    public void 로또번호가_범위를_벗어나는지_확인() {
        // given
        int lottoNumber = Lotto.MAX_NUMBER;
        int outOfRangeNumber = Lotto.MAX_NUMBER + 1;

        // when
        // then
        assertThat(LottoNumberValidator.isLottoNumberCorrect(lottoNumber)).isTrue();
        assertThat(LottoNumberValidator.isLottoNumberCorrect(outOfRangeNumber)).isFalse();
    }

    @Test
    public void 로또번호_리스트가_범위를_벗어나는지_확인() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> outOfRangeNumbers = Arrays.asList(1, 2, 3, 4, 5, (Lotto.MAX_NUMBER + 1));

        // when
        // then
        assertThat(LottoNumberValidator.isLottoNumbersCorrect(lottoNumbers)).isTrue();
        assertThat(LottoNumberValidator.isLottoNumbersCorrect(outOfRangeNumbers)).isFalse();
    }
}
