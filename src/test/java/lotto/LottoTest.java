package lotto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void 로또_생성() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또번호_생성() {
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 일치하는_숫자_개수_반환() {
        assertThat(lotto.countMatchingNumbers(Arrays.asList(1, 2, 3, 10, 11, 12))).isEqualTo(3);
        assertThat(lotto.countMatchingNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

}