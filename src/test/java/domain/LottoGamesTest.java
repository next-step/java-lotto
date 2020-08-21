package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoGamesTest {

    @Test
    void calculateWinnerRank(){
        int count = 3;

//        WinnerRanking ranking = new WinnerRanking(5000,"R4");

//        int price = ranking.getWinnerPrice();
//        String rank = ranking.getRanking();

        assertThat(new LottoGames().calculateWinnerRank(count)).isEqualTo(5000);


    }
}
