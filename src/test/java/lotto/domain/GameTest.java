package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        Set<Ball> ballSet = Sets.newLinkedHashSet(new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4),
                new Ball(5),
                new Ball(6));

        List<Lotto> lottoList = Collections.singletonList(new Lotto(ballSet));
        game = new Game(lottoList);
    }

    @Test
    @DisplayName("게임 생성")
    void create() {
        assertThat(game.getLottoSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 로또 game 생성")
    void createRandom() {
        List<Lotto> lottoList = LottoMachine.buyRandomLotto(5000);
        Game game = new Game(lottoList);
        assertThat(game.getLottoSize()).isEqualTo(5);
    }

    @Test
    @DisplayName("지난 당첨번호 지정하기")
    void settingPreviousLotto() {
        game.setPreviousLotto(new Lotto(
                Sets.newLinkedHashSet(new Ball(1),
                        new Ball(2),
                        new Ball(3),
                        new Ball(4),
                        new Ball(5),
                        new Ball(6))));

        assertThat(game.getLottoSize()).isEqualTo(1);
        assertThat(game.getLottoList().get(0).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
