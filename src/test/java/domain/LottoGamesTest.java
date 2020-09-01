package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGamesTest {

    @Test
    void makeLottoTicketTest() {
        assertThatThrownBy(() -> new LottoGames(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Price ERR");
    }

    @DisplayName("상금 테스트")
    @Test
    void sumOfWinnerPrice() {
        String[] input = "1,2,3,4,5,6".split(",");
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        LottoGames game = new LottoGames(0);
        game.getLottos().addLotto(new Lotto(set));

        assertThat(game.calculateWinnerPrice(new WinnerNumber(input, bonus)))
                .isEqualTo(2_000_000_000);
    }

    @DisplayName("상금 테스트2")
    @Test
    void sumOfWinnerPrice2() {
        String[] input = "1,2,3,4,5,6".split(",");
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        int bonus = 7;

        LottoGames game = new LottoGames(0);
        game.getLottos().addLotto(new Lotto(set));

        assertThat(game.calculateWinnerPrice(new WinnerNumber(input, bonus)))
                .isEqualTo(30_000_000);
    }

    @DisplayName("상금 테스트3")
    @Test
    void sumOfWinnerPrice3() {
        String[] input = "1,2,3,4,5,6".split(",");
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        int bonus = 9;

        LottoGames game = new LottoGames(0);
        game.getLottos().addLotto(new Lotto(set));

        assertThat(game.calculateWinnerPrice(new WinnerNumber(input, bonus)))
                .isEqualTo(1_500_000);
    }

    @DisplayName("보너스 번호 찾기 테스트")
    @Test
    void findBonusTest() {
        String[] input = "1,2,3,4,5,6".split(",");
        int bonus = 7;

        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));

        LottoGames game = new LottoGames(0);
        WinnerNumber winnerNumber = new WinnerNumber(input, bonus);
        game.setWinnerNumber(winnerNumber);
        Lotto lotto = new Lotto(set);

        assertThat(game.findBonus(lotto)).isEqualTo(7);
    }
}
