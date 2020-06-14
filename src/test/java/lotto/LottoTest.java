package lotto;

import lotto.model.LottoGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    static LottoGame sampleGame;
    @BeforeAll
    public static void setup() {
        sampleGame = new LottoGame(new int[]{2, 5, 7, 13, 16, 19});
    }
    @Test
    public void testIsLottoWinner() {
        LottoGame game = new LottoGame(new int[]{1, 2, 3, 4, 5, 6});

        assertThat(game.getPageContent()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(game.LottoCompare(new int[]{1, 2, 3, 4, 5, 6}, 7)).isEqualTo(6);
    }

    @Test
    public void testLottoFailed() {
        assertThat(sampleGame.LottoCompare(new int[]{1, 3, 4, 6, 8, 9}, 2)).isEqualTo(0);
    }

    @Test
    public void testLottoGenerator() {
        LottoGame game = new LottoGame();
        assertThat(game.getPageContent().split(", ").length).isEqualTo(6);
    }

    @Test
    public void testLottoCountError() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoGame(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    public void testWinnerCount() {
        assertThat(sampleGame.LottoCompare(new int[]{2, 3, 7, 13, 21, 34}, 1)).isEqualTo(3);
    }

    @Test
    public void testBonusWinnerCount() {
        // LottoSinglePage page = new LottoSinglePage(new int[] {2, 5, 7, 13, 16, 19});
        assertThat(sampleGame.LottoCompare(new int[]{3, 5, 7, 13, 16, 19}, 2)).isEqualTo(5.5);
    }
}
