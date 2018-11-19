package lotto.service;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 구매갯수구하기() {

        assertThat(LottoGame.getNumOfGames(14000)).isEqualTo(14);
    }

    @Deprecated
    public void 게임수_리스트_만들기() {
        LottoGame lg = new LottoGame(14000,3);
        assertThat(lg.getGamePlays().size()).isEqualTo(14);
    }

    /**
     * 게임 세팅의 경우, 생성자에서 자동 생성 되도록 작업해주는 것이 맞을까?
     */
    @Deprecated
    public void 생성자테스트() {
        LottoGame lg = new LottoGame(14000,3);
        System.out.println(lg.getGamePlays());
    }


    /**
     * INput값을 LottoResult에서 받는 것이 안좋아 보인다.
     * 그렇다고 main에서 계속 인풋을 받아 실행시켜주는 것은 맞을까.
     */
    @Deprecated
    public void 수동게임제거테스트() {
        LottoGame lottoGame = new LottoGame(14000, 4);
        lottoGame.gameSettingAutoGames();
        assertThat(lottoGame.getGamePlays().size()).isEqualTo(10);

    }
}
