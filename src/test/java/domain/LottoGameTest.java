package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp(){
        lottoGame = new LottoGame();
    }
    @Test
    void 일등() {
        final var actual = lottoGame.match(
                new Lotto(1,2,3,4,5,6),
                new WinningLotto(new Lotto(1,2,3,4,5,6), new LottoNumber(7))
        );
        assertThat(actual).isEqualTo(1);
    }


    @Test
    void 이등() {
        final var actual = lottoGame.match(
                new Lotto(1,2,3,4,5,7),
                new WinningLotto(new Lotto(1,2,3,4,5,6), new LottoNumber(7))
        );
        assertThat(actual).isEqualTo(2);
    }
    @Test
    void 삼등() {
        final var actual = lottoGame.match(
                new Lotto(1,2,3,4,5,8),
                new WinningLotto(new Lotto(1,2,3,4,5,6), new LottoNumber(7))
        );
        assertThat(actual).isEqualTo(3);
    }
    @Test
    void 사등() {
        final var actual = lottoGame.match(
                new Lotto(1,2,3,4,7,8),
                new WinningLotto(new Lotto(1,2,3,4,5,6), new LottoNumber(7))
        );
        assertThat(actual).isEqualTo(4);
    }
    @Test
    void 오등() {
        final var actual = lottoGame.match(
                new Lotto(1,2,3,7,8,9),
                new WinningLotto(new Lotto(1,2,3,4,5,6), new LottoNumber(7))
        );
        assertThat(actual).isEqualTo(5);
    }


}
