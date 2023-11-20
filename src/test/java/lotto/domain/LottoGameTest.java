package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoGameTest {
    @Test
    @DisplayName("1등")
    void rank_1() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto winningLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        int rank = LottoGame.match(lotto, winningLotto);
        Assertions.assertThat(rank).isEqualTo(1);
    }
    @Test
    @DisplayName("2등")
    void rank_2() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)));
        Lotto winningLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        int rank = LottoGame.match(lotto, winningLotto);
        Assertions.assertThat(rank).isEqualTo(2);
    }
    @Test
    @DisplayName("3등")
    void rank_3() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(10), new LottoNumber(7)));
        Lotto winningLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        int rank = LottoGame.match(lotto, winningLotto);
        Assertions.assertThat(rank).isEqualTo(3);
    }
    @Test
    @DisplayName("4등")
    void rank_4() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(10), new LottoNumber(3), new LottoNumber(45), new LottoNumber(7)));
        Lotto winningLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        int rank = LottoGame.match(lotto, winningLotto);
        Assertions.assertThat(rank).isEqualTo(4);
    }
    @Test
    @DisplayName("꼴등")
    void rank_0() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(35), new LottoNumber(45), new LottoNumber(10), new LottoNumber(3), new LottoNumber(5), new LottoNumber(7)));
        Lotto winningLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        int rank = LottoGame.match(lotto, winningLotto);
        Assertions.assertThat(rank).isEqualTo(0);
    }
}
