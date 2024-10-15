package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GamesTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a", "가", "."})
    void 구매_금액은_숫자만_처리할_수_있다(String input) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());

        assertThatIllegalArgumentException().isThrownBy(() -> new Games(input, generator))
                .withMessage("구매 금액은 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "500", "999"})
    void 최소_구매_금액_이상이_필요하다(String money) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());

        assertThatIllegalArgumentException().isThrownBy(() -> new Games(money, generator))
                .withMessage(String.format("최소 %d원이 필요합니다.", Game.PRICE));
    }

    @ParameterizedTest
    @CsvSource({"1000, 1", "10500, 10"})
    void 구매_금액에_맞는_갯수의_게임을_생성한다(String money, int expected) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());
        Games games = new Games(money, generator);

        assertThat(games.count()).isEqualTo(expected);
    }
}