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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    Game game;
    Ball bonusBall = new Ball(40);
    LinkedHashSet<Ball> previousBallSet = Sets.newLinkedHashSet(
            new Ball(10),
            new Ball(11),
            new Ball(12),
            new Ball(13),
            new Ball(14),
            new Ball(45));

    @BeforeEach
    void setUp() {

        List<Lotto> lottoList = new ArrayList<>(14);

        Set<Ball> ballSet123456 = Sets.newLinkedHashSet(new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4),
                new Ball(5),
                new Ball(6));

        LinkedHashSet<Ball> winnerBallSet = Sets.newLinkedHashSet(
                new Ball(10),
                new Ball(11),
                new Ball(12),
                new Ball(13),
                new Ball(14),
                new Ball(15));

        for (int i = 0; i < 13; i++) {
            lottoList.add(new Lotto(ballSet123456));
        }
        lottoList.add(new Lotto(winnerBallSet));

        game = new Game(lottoList);
        PreviousLotto previousLotto = PreviousLotto.of(new Lotto(previousBallSet), bonusBall);
        game.match(previousLotto);
    }

    @Test
    @DisplayName("게임 생성")
    void create() {
        assertThat(game.getLottos()).hasSize(14);
    }

    @Test
    @DisplayName("랜덤 로또 game 생성")
    void createRandom() {
        List<Lotto> lottoList = LottoMachine.buyRandomLotto(5000);
        Game game = new Game(lottoList);
        assertThat(game.getLottos()).hasSize(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:0", "5:1", "6:0"}, delimiter = ':')
    @DisplayName("일치하는 번호 갯수 출력")
    void getNumberOfRightNumber(int sameNumberCount, int expected) {
        assertThat(game.countReward(Reward.valueOf(sameNumberCount, false))).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:0", "5:1", "6:0"}, delimiter = ':')
    @DisplayName("보너스볼 2등 체크하기")
    void checkBonusBall(int sameNumberCount, int expected) {
        bonusBall = new Ball(15);
        setUp();
        assertThat(game.countReward(Reward.valueOf(sameNumberCount, true))).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률 계산하기")
    void getYield() {
        previousBallSet = Sets.newLinkedHashSet(
                new Ball(10),
                new Ball(11),
                new Ball(12),
                new Ball(43),
                new Ball(44),
                new Ball(45));
        setUp();
        assertThat(game.getLottos()).hasSize(14);
        assertThat(game.getYield()).isEqualTo("0.35");
    }


    @Test
    @DisplayName("지난 주 당첨 번호에 보너스 공이 포함되어 있으면 에러가 발생한다.")
    void validBonusBall() {
        bonusBall = new Ball(14);

        assertThatThrownBy(this::setUp
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
