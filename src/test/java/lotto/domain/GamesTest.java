package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GamesTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 500, 999})
    void 최소_구매_금액_이상이_필요하다(int money) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());

        assertThatIllegalArgumentException().isThrownBy(() -> new Games(money, generator))
                .withMessage(String.format("최소 %d원이 필요합니다.", Game.PRICE));
    }

    @ParameterizedTest
    @CsvSource({"1000, 1", "10500, 10"})
    void 구매_금액에_맞는_갯수의_게임을_생성한다(int money, int expected) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());
        Games games = new Games(money, generator);

        assertThat(games.count()).isEqualTo(expected);
    }

    @Test
    @DisplayName("toString()은 [번호, 번호]\n[번호, 번호] 형식의 문자열을 반환한다.")
    void toString은_전체_게임의_로또번호를_반환한다() {
        Game game1 = new Game(List.of(1, 2, 3, 4, 5, 6));
        Game game2 = new Game(List.of(7, 8, 9, 10, 11, 12));
        Game game3 = new Game(List.of(13, 14, 15, 16, 17, 18));
        Games games = new Games(game1, game2, game3);

        String[] toStringArray = {game1.toString(), game2.toString(), game3.toString()};
        String expected = String.join("\n", toStringArray);

        assertThat(games).hasToString(expected);
    }
}