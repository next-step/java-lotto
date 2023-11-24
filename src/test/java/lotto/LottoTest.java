package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void calculateSameNumber() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 45);
        Lotto winningLotto = Lotto.of(1, 2, 3, 4, 5, 6);

        assertThat(lotto.calculateSameNumber(winningLotto)).isEqualTo(5);
    }

    @Test
    void contain() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 45);
        LottoNumber bonusBall45 = LottoNumber.from(45);
        LottoNumber bonusBall40 = LottoNumber.from(40);

        assertThat(lotto.contain(bonusBall45)).isTrue();
        assertThat(lotto.contain(bonusBall40)).isFalse();
    }
}
