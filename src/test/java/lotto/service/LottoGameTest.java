package lotto.service;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 구매갯수구하기() {

        assertThat(LottoGame.getNumOfGames(14000)).isEqualTo(14);
    }

    @Test
    public void 게임수_리스트_만들기() {
        LottoGame lg = new LottoGame(14000);
        lg.gameSettingAllFrame();
        assertThat(lg.getGamePlays().size()).isEqualTo(14);
    }


    @Test
    public void 생성자테스트() {
        LottoGame lg = new LottoGame(14000);
        lg.gameSettingAllFrame();
        System.out.println(lg.getGamePlays());
    }
}
