package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    Game game;
    Ball bonusBall = Ball.of(40);

    @BeforeEach
    void setUp() {
        List<Lotto> lottoList = new ArrayList<>(14);

        for (int i = 0; i < 13; i++) {
            lottoList.add(Lotto.of(1, 2, 3, 4, 5, 6));
        }
        lottoList.add(Lotto.of(10, 11, 12, 13, 14, 15));

        game = Game.of(lottoList);
        PreviousLotto previousLotto = PreviousLotto.of(Lotto.of(10, 11, 12, 13, 14, 45), bonusBall);
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
        Game game = Game.of(lottoList);
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
        bonusBall = Ball.of(15);
        setUp();
        assertThat(game.countReward(Reward.valueOf(sameNumberCount, true))).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률 계산하기")
    void getYield() {
        game.match(PreviousLotto.of(Lotto.of(10, 11, 12, 43, 44, 45), Ball.of(15)));
        assertThat(game.getLottos()).hasSize(14);
        assertThat(game.getYield()).isEqualTo("0.35");
    }

}
