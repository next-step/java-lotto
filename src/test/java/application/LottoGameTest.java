package application;

import domain.Winning;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    @Test
    public void 로또여러장구매() {
        int price = 14000;
        LottoGame game = new LottoGame(price);

        assertThat(game.getSize()).isEqualTo(14);
    }

    @Test
    public void 로또게임_당첨금액_입력() {
        int price = 1000;
        LottoGame game = new LottoGame(price);

        String number = "1, 2, 3, 4, 5, 6";
        Winning winning = new Winning(number);
        game.run(winning);
    }
}
