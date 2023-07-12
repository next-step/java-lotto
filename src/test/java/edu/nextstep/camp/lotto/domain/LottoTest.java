package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    void 로또_맞은_번호_갯수() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.matchNumberCount(new Lotto(1, 2, 3, 4, 5, 6))).isEqualTo(6);
        assertThat(lotto.matchNumberCount(new Lotto(1, 2, 3, 7, 8, 9))).isEqualTo(3);
    }

    @Test
    void 중복_체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 5))
                .withMessageContaining("duplicate numbers");
    }

    @Test
    void 번호_정렬_체크() {
        Lotto lotto = new Lotto(7, 43, 5, 2, 32, 26);

        String result = lotto.toString();

        assertThat(result).contains("[2, 5, 7, 26, 32, 43]");
    }
}
