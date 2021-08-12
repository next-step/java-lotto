package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class PlayLottoTest {

    @DisplayName("로또 맞춘 갯수 구하기")
    @Test
    void findCorrect() {
        Lotto win = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(win.countSameNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)))).isEqualTo(4);
        assertThat(win.countSameNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
        assertThat(win.countSameNumber(new Lotto(Arrays.asList(45, 44, 43, 42, 41, 40)))).isEqualTo(0);
    }


}