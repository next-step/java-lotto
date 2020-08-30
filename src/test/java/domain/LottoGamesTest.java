package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    void sumOfWinnerPrice(){
        String[] input = "1,2,3,4,5,6".split(",");
        List<Integer > list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        LottoGames game = new LottoGames(0);
        game.getLottos().addLotto(new Lotto(list));

//        assertThat(game.calculateWinnerPrice(new WinnerNumber(input)))
//                .isEqualTo(2_000_000_000);
    }

    @DisplayName("보너스 번호 테스트")
    @Test
    void bonusTest(){
        String[] input = "1,2,3,4,5,6".split(",");
        int bonus = 7;
        List<Integer > list = new ArrayList<>(Arrays.asList(1,2,3,4,5,7));

        LottoGames game = new LottoGames(0);

        List<Integer> list = lotto.getLottoNumber().stream()
                .filter(e->!winnerNumber.getWinnerNumber().contains(e));
    }
}
