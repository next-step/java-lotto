package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("모든 게임에 당첨")
    void game_win() {
        Game game = new Game(new Positive(10), () -> LottoTestUtil.toLottoNumberList(1, 11, 14, 15, 18, 20));
        LottoResult result = game.play(new Lotto(LottoTestUtil.toLottoNumberList(1, 11, 14, 15, 18, 20)), new LottoNumber(21));

        assertThat(result.getPrizeCount(Prize.SIX)).isEqualTo(10);
    }

    @Test
    @DisplayName("당첨 결과 확인")
    void game() {
        Game game = new Game(new Positive(7), new TestLottoPublisher(List.of(
                List.of(1, 11, 14, 15, 18, 20),
                List.of(1, 11, 14, 16, 18, 20),
                List.of(3, 4, 5, 6, 7, 8),
                List.of(3, 4, 5, 6, 7, 18),
                List.of(1, 14, 15, 16, 30, 45),
                List.of(3, 14, 18, 20, 21, 22),
                List.of(3, 7, 14, 19, 20, 33)
        )));
        LottoResult result = game.play(new Lotto(LottoTestUtil.toLottoNumberList(1, 11, 14, 15, 18, 20)), new LottoNumber(21));

        assertThat(result.getPrizeCount(Prize.NONE)).isEqualTo(3);
        assertThat(result.getPrizeCount(Prize.THREE)).isEqualTo(2);
        assertThat(result.getPrizeCount(Prize.FIVE)).isEqualTo(1);
        assertThat(result.getPrizeCount(Prize.SIX)).isEqualTo(1);
    }

    @Test
    @DisplayName("수동으로 입력한 로또 확인")
    void game_self() {
        Lottos selfLotto = new Lottos(List.of(
                new Lotto(LottoTestUtil.toLottoNumberList(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoTestUtil.toLottoNumberList(1, 2, 3, 4, 5, 7)),
                new Lotto(LottoTestUtil.toLottoNumberList(1, 11, 14, 15, 18, 21)),
                new Lotto(LottoTestUtil.toLottoNumberList(1, 11, 14, 15, 18, 20))
        ));
        Game game = new Game(new Positive(11), selfLotto, new TestLottoPublisher(List.of(
                List.of(1, 11, 14, 15, 18, 20),
                List.of(1, 11, 14, 16, 18, 20),
                List.of(3, 4, 5, 6, 7, 8),
                List.of(3, 4, 5, 6, 7, 18),
                List.of(1, 14, 15, 16, 30, 45),
                List.of(3, 14, 18, 20, 21, 22),
                List.of(3, 7, 14, 19, 20, 33)
        )));
        LottoResult result = game.play(new Lotto(LottoTestUtil.toLottoNumberList(1, 11, 14, 15, 18, 20)), new LottoNumber(21));

        assertThat(result.getPrizeCount(Prize.NONE)).isEqualTo(5);
        assertThat(result.getPrizeCount(Prize.THREE)).isEqualTo(2);
        assertThat(result.getPrizeCount(Prize.FIVE)).isEqualTo(1);
        assertThat(result.getPrizeCount(Prize.FIVE_BONUS)).isEqualTo(1);
        assertThat(result.getPrizeCount(Prize.SIX)).isEqualTo(2);
    }
}
