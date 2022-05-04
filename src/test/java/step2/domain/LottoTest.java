package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.service.TestPick;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("pick strategy 테스트")
    @Test
    void testPickStrategy() {
        Lotto lotto = new Lotto(new TestPick(Arrays.asList(10, 2, 3, 4, 5, 6)));
        assertThat(lotto.pick()).containsExactly(2, 3, 4, 5, 6, 10);
    }

    @DisplayName("당첨번호와 몇개가 매칭되는지 테스트한다")
    @Test
    void pickNumberCheck() {
        Lotto lotto = new Lotto(new TestPick(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(lotto.numberCheck(Arrays.asList(11, 12, 13, 4, 5, 6))).isEqualTo(3);
    }
}