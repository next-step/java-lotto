package domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGamesTest {

    @Test
    void makeLottoAuto(){
        assertThat(new LottoGames(100,0)
                .getLottos().getNumOfLottos()).isEqualTo(100);
    }
}
