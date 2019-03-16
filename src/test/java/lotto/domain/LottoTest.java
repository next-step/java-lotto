package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
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
