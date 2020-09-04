package domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGamesTest {

    @Test
    void manualMakeLottoTest(){
        LottoGames game = new LottoGames(7,3);


        assertThat(new LottoGames(100,3)
                .getLottos().getNumOfLottos()).isEqualTo(103);
    }

    @Test
    void makeLottoAuto(){
        assertThat(new LottoGames(100,0)
                .getLottos().getNumOfLottos()).isEqualTo(103);
    }
}
