package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    @Test
    public void create(){
        LottoGame lotto = new LottoGame(3000);
        assertThat(lotto.getBuyRound()).isEqualTo(3);
    }
}
