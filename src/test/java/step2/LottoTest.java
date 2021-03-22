package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Game;
import step2.domain.Lotto;
import step2.domain.Number;
import step2.domain.Seed;

public class LottoTest {

    private final int lengthPerGame = 6;
    private final int pricePerGame = 1000;
    private Lotto lotto;
    private Seed seed;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(lengthPerGame);
        seed = new Seed(14000);
    }

    @DisplayName("한 게임 당 1000원이고 시드머니가 14000이면 14게임")
    @Test
    void gameSize() {
        int gameSize = seed.amount() / pricePerGame;

        lotto.init(gameSize, lengthPerGame);

        assertEquals(gameSize, lotto.size());
    }

    @DisplayName("입력받은 개수만큼 게임생성")
    @Test
    void generateGames() {
        lotto.init(seed.amount() / pricePerGame, lengthPerGame);
        List<Game> games = lotto.games();

        for (int count = 0; count < lotto.size(); ++count) {
            Game game = games.get(count);
            Set<Number> numbers = new HashSet<>(game.numbers());
            assertEquals(lengthPerGame, numbers.size());
        }
    }

    @DisplayName("당첨번호 생성")
    @Test
    void generateLastPrize() {
        String input = "1,2,3,4,5,6";
        lotto.initLastPrize(input);
        Game lastPrize = lotto.lastPrize();
        Set<Number> numbers = new HashSet<>(lastPrize.numbers());
        assertEquals(lengthPerGame, numbers.size());
    }
}
