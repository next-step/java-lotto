package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static step2.LottoApplication.LENGTH_PER_GAME;
import static step2.LottoApplication.PRICE_PER_GAME;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Game;
import step2.domain.Lotto;
import step2.domain.Number;
import step2.domain.Prize;
import step2.domain.Rank;
import step2.domain.Seed;

public class LottoTest {

    private Lotto lotto;
    private Seed seed;
    private Prize prize;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
        seed = new Seed(14000);
    }

    @DisplayName("한 게임 당 1000원이고 시드머니가 14000이면 14게임")
    @Test
    void gameSize() {
        lotto.init(seed.amount(), PRICE_PER_GAME, LENGTH_PER_GAME);

        assertEquals(seed.amount() / PRICE_PER_GAME, lotto.size());
    }

    @DisplayName("입력받은 개수만큼 게임생성")
    @Test
    void generateGames() {
        lotto.init(seed.amount(), PRICE_PER_GAME, LENGTH_PER_GAME);
        List<Game> games = lotto.games();

        for (int count = 0; count < lotto.size(); ++count) {
            Game game = games.get(count);
            Set<Number> numbers = new HashSet<>(game.numbers());
            assertEquals(LENGTH_PER_GAME, numbers.size());
        }
    }

    @DisplayName("당첨번호 생성")
    @Test
    void generateLastPrize() {
        prize = new Prize("1,2,3,4,5,6", "7");
        Game lastPrize = prize.last();
        Set<Number> numbers = new HashSet<>(lastPrize.numbers());
        assertEquals(LENGTH_PER_GAME, numbers.size());
    }

    @DisplayName("당첨테스트")
    @Test
    void prize() {
        prize = new Prize("1,2,3,4,5,6", "7");
        List<Game> games = lotto.games();
        initGames(games);

        lotto.match(prize);
        Map<Rank, List<Game>> candidate = lotto.candidate();
        candidate.forEach((key, value) -> {
            if (key.equals(Rank.FIFTH)) {
                assertEquals(3, value.size());
            } else if (key.equals(Rank.FOURTH)) {
                assertEquals(2, value.size());
            } else if (key.equals(Rank.THIRD)) {
                assertEquals(1, value.size());
            } else if (key.equals(Rank.FIRST)) {
                assertEquals(1, value.size());
            } else if (key.equals(Rank.SECOND)) {
                assertEquals(1, value.size());
            }
        });
    }

    private void initGames(List<Game> games) {
        games.add(new Game(Arrays.asList(1, 2, 3, 14, 15, 16)));
        games.add(new Game(Arrays.asList(11, 12, 13, 4, 5, 6)));
        games.add(new Game(Arrays.asList(11, 12, 3, 14, 5, 6)));
        games.add(new Game(Arrays.asList(1, 2, 3, 4, 15, 16)));
        games.add(new Game(Arrays.asList(1, 2, 3, 14, 5, 16)));
        games.add(new Game(Arrays.asList(1, 2, 3, 4, 5, 16)));
        games.add(new Game(Arrays.asList(1, 2, 3, 4, 5, 6)));
        games.add(new Game(Arrays.asList(1, 2, 3, 4, 5, 7)));
    }
}
