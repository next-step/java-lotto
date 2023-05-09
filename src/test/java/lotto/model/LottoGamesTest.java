package lotto.model;

import lotto.model.enums.MatchingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGamesTest {

    @Test
    @DisplayName("구입한 갯수 만큼 Lotto 갯수를 생성한다.")
    void check_lotto_game_count() {
        LottoGames games = new LottoGames(5);
        assertThat(games.getGameCount()).isEqualTo(5);
    }


    @Test
    @DisplayName("6개 동일 Case")
    void test_case_winner_with_match_six() {

        LottoGames games = getLottoGames();
        games.setWinningNumbers(Set.of(1, 2, 3, 4, 5, 6));
        games.setBonusNumber(7);
        games.aggregate();

        assertThat(games.getStatistic().get(MatchingStrategy.SIX).size()).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 동일 with bonus Case")
    void test_case_winner_with_match_five_with_bonus() {

        LottoGames games = getLottoGames();
        games.setWinningNumbers(Set.of(19, 29, 30, 1, 33, 6));
        games.setBonusNumber(32);
        games.aggregate();

        assertThat(games.getStatistic().get(MatchingStrategy.FIVE_WITH_BONUS).size()).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 동일 Case")
    void test_case_winner_with_match_five() {

        LottoGames games = getLottoGames();
        games.setWinningNumbers(Set.of(19, 36, 7, 5, 23, 6));
        games.setBonusNumber(32);
        games.aggregate();

        assertThat(games.getStatistic().get(MatchingStrategy.FIVE).size()).isEqualTo(1);
    }

    @Test
    @DisplayName("4개 동일 Case")
    void test_case_winner_with_match_four() {

        LottoGames games = getLottoGames();
        games.setWinningNumbers(Set.of(19, 28, 30, 12, 39, 44));
        games.setBonusNumber(32);
        games.aggregate();

        assertThat(games.getStatistic().get(MatchingStrategy.FOUR).size()).isEqualTo(1);
    }

    private LottoGames getLottoGames() {
        LottoGames games = new LottoGames();
        games.addLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 6)));
        games.addLotto(new Lotto(Set.of(19, 29, 30, 1, 41, 32)));
        games.addLotto(new Lotto(Set.of(19, 36, 7, 5, 23, 4)));
        games.addLotto(new Lotto(Set.of(19, 28, 30, 12, 2, 45)));
        games.setBonusNumber(7);
        return games;
    }

}