package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    void create() {
        WinningLotto lotto = new WinningLotto("1,2,3,4,5,6");
        assertThat(lotto).isEqualTo(new WinningLotto("1,2,3,4,5,6"));
    }


    @DisplayName("로또 번호 매칭")
    @Test
    void matchWithWinningLotto() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int count = lotto.match(new WinningLotto("1,2,3,4,5,10").getNumbers());
        assertThat(count).isEqualTo(5);
    }
}
