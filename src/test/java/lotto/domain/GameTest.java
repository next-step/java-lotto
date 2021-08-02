package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game;

    @BeforeEach
    void setUp() {

        List<Lotto> lottoList = new ArrayList<>(14);

        Set<Ball> ballSet123456 = Sets.newLinkedHashSet(new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4),
                new Ball(5),
                new Ball(6));

        LinkedHashSet<Ball> ballSet = Sets.newLinkedHashSet(
                new Ball(10),
                new Ball(11),
                new Ball(12),
                new Ball(13),
                new Ball(14),
                new Ball(15));

        LinkedHashSet<Ball> previousBallSet = Sets.newLinkedHashSet(
                new Ball(10),
                new Ball(11),
                new Ball(12),
                new Ball(43),
                new Ball(44),
                new Ball(45));

        for (int i = 0; i < 13; i++) {
            lottoList.add(new Lotto(ballSet123456));
        }
        lottoList.add(new Lotto(ballSet));

        game = new Game(lottoList);
        game.setPreviousLotto(new Lotto(previousBallSet));
    }

    @Test
    @DisplayName("게임 생성")
    void create() {
        assertThat(game.getLottoList()).hasSize(14);
    }

    @Test
    @DisplayName("랜덤 로또 game 생성")
    void createRandom() {
        List<Lotto> lottoList = LottoMachine.buyRandomLotto(5000);
        Game game = new Game(lottoList);
        assertThat(game.getLottoList()).hasSize(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:1", "4:0", "5:0", "6:0"}, delimiter = ':')
    @DisplayName("일치하는 번호 갯수 출력")
    void getNumberOfRightNumber(int rightNumber, int expected) {
        assertThat(game.getNumberOfRightLotto(rightNumber)).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률 계산하기")
    void getYield() {
        assertThat(game.getLottoList()).hasSize(14);
        assertThat(game.getYield()).isEqualTo("0.35");
    }
}
