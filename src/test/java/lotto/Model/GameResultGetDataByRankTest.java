package lotto.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultGetDataByRankTest {
    GameResult gameResult;

    @BeforeEach
    public void setUp() {
        gameResult = new GameResult();
/*
        HashMap<Integer, Integer> input = new HashMap<>() {{
            put(3, 5);
            put(4, 4);
            put(5, 3);
            put(15, 2);
            put(6, 1);
        }};
*/
        for(int i = 0; i < 5; i++) {
            gameResult.addCount(3, false);
        }
        for(int i = 0; i < 4; i++) {
            gameResult.addCount(4, false);
        }
        for(int i = 0; i < 3; i++) {
            gameResult.addCount(5, false);
        }
        for(int i = 0; i < 2; i++) {
            gameResult.addCount(5, true);
        }
        for(int i = 0; i < 1; i++) {
            gameResult.addCount(6, false);
        }
    }

    @Test
    @DisplayName("1등 티켓 개수 확인")
    public void gameResult_get_count_rank_1() {
        int expected = 1;
        int actual = gameResult.countOfTicketByRank(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("2등 티켓 개수 확인")
    public void gameResult_get_count_rank_2() {
        int expected = 2;
        int actual = gameResult.countOfTicketByRank(2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("3등 티켓 개수 확인")
    public void gameResult_get_count_rank_3() {
        int expected = 3;
        int actual = gameResult.countOfTicketByRank(3);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등 티켓 개수 확인")
    public void gameResult_get_count_rank_4() {
        int expected = 4;
        int actual = gameResult.countOfTicketByRank(4);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("5등 티켓 개수 확인")
    public void gameResult_get_count_rank_5() {
        int expected = 5;
        int actual = gameResult.countOfTicketByRank(5);

        assertThat(actual).isEqualTo(expected);
    }
}