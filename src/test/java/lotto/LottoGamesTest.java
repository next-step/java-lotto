package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGamesTest {

    @Test
    @DisplayName("로또 수익률 계산")
    public void returnRate() {
        LottoGames lottoGames = new LottoGames(List.of("1, 2, 3, 41, 42, 43"), "1, 2, 3, 4, 5, 6");
        lottoGames.calculatePrizeCount();
        assertThat(lottoGames.calculateReturn()).isEqualTo(5);
    }

    @Test
    @DisplayName("인풋만큼 로또 게임 생성")
    public void gameMakeTest() {
        LottoGames lottoGames = new LottoGames(14);
        assertThat(lottoGames.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("상금별 당첨이 몇개가 있는지 확인")
    public void calculatePrizeCountTest() {
        LottoGames lottoGames = new LottoGames(List.of("1, 2, 3, 41, 42, 43"), "1, 2, 3, 4, 5, 6");
        lottoGames.calculatePrizeCount();
        assertThat(lottoGames.getLottoResult()).containsExactly(0, 0, 0, 1, 0, 0, 0);
    }


}
