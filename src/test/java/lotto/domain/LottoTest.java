package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("당첨 로또와 일치하는 개수 추출")
    void 당첨_로또와_일치하는_개수_추출() {
        Lotto winner = new Lotto("1,2,3,4,5,6");
        Lotto lotto = new Lotto("7,8,9,4,5,6");
        assertThat(lotto.compareWinningNumber(winner)).isEqualTo(3);
    }

}
