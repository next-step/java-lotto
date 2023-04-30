package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGamesTest {

    @Test
    @DisplayName("구입한 갯수 만큼 Lotto 갯수를 생성한다.")
    void check_lotto_game_count(){
        LottoGames games = new LottoGames(5);
        assertThat(games.getGameCount()).isEqualTo(5);
    }

}