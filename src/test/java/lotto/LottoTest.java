package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("한 개의 로또에 일치하는 개수 확인")
    void 일치하는_개수_확인() {
        Lotto lotto = new Lotto(Arrays.asList(7, 2, 4, 5, 22, 37));
        assertThat(lotto.calculateMatchCount(new Lotto(Arrays.asList(1, 5, 13, 22, 43, 37)), 15)).isEqualTo(3);
        assertThat(lotto.getIsBonusMatch()).isEqualTo(false);

        Lotto lotto2 = new Lotto(Arrays.asList(7, 2, 4, 5, 22, 37));
        assertThat(lotto2.calculateMatchCount(new Lotto(Arrays.asList(1, 5, 13, 22, 43, 37)), 7)).isEqualTo(3);
        assertThat(lotto2.getIsBonusMatch()).isEqualTo(true);
    }

}
