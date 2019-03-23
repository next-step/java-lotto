package application;

import domain.Winning;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    @Test
    public void 로또여러장구매() {
        int price = 14000;
        LottoGame game = new LottoGame(price, new Random());

        assertThat(game.getSize()).isEqualTo(14);
    }

    @Test
    public void 로또게임_당첨금액_입력() {
        int price = 1000;
        LottoGame game = new LottoGame(price, new Random(29));
        String number = "1, 2, 3, 4, 5, 7";
        Winning winning = new Winning(number);
        List<Integer> results = game.run(winning);

        assertThat(results.get(3)).isEqualTo(1);
    }

    @Test
    public void 보너스볼_입력() {
        int price = 1000;
        LottoGame game = new LottoGame(price, new Random(6));

        String number = "1, 2, 3, 4, 5, 6";
        int bouns = 7;

        Winning winning = new Winning(number, bouns);
        List<Integer> results = game.run(winning);

        assertThat(results.get(0)).isEqualTo(1);
    }
}
