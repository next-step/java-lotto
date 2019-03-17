package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void 로또_생성_시_숫자_중복되면_IlligalArgumentException() {
        // given
        List<Integer> duplicatedNumbers = Arrays.asList(1, 1, 3, 4, 5, 6);

        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(duplicatedNumbers));
    }

    @Test
    public void 로또_생성_시_숫자가_6개가_아니면_IlligalArgumentException() {
        // given
        List<Integer> fiveNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sevenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(fiveNumbers));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(sevenNumbers));
    }

    @Test
    public void 로또_생성_시_숫자가_범위를_벗어나면_IlligalArgumentException() {
        // given
        List<Integer> outOfRangeNumbers = Arrays.asList(100, 2, 3, 4, 5, 6);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(outOfRangeNumbers));
    }

    @Test
    public void 서로_겹치는_로또숫자_갯수_구하기() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto six = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto zero = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));

        // when
        int shouldBeSix = lotto.getNumberOfDuplicatedNumbers(six);
        int shouldBeZero = lotto.getNumberOfDuplicatedNumbers(zero);

        // then
        assertThat(shouldBeSix).isEqualTo(6);
        assertThat(shouldBeZero).isEqualTo(0);
    }
}
