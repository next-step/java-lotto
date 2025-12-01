package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또_개수_구하기() {
        Lotto lotto = new Lotto(1,2,3,4,5,6);

        assertThat(lotto.countMatchedNumbers(
                new Lotto(1,2,3,11,22,33)
        )).isEqualTo(3);
    }

    @Test
    void 포함된_숫자인지() {
        Lotto lotto = new Lotto(1,2,3,4,5,6);

        assertThat(lotto.contains(LottoNumber.valueOf(1))).isTrue();
    }

    @Test
    void 로또_스트링으로_받기() {
        Lotto lotto = new Lotto("1","2","3","4","5","6");

        assertThat(lotto.countMatchedNumbers(
                new Lotto(1,2,3,11,22,33)
        )).isEqualTo(3);
    }
}
