package lottoauto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {
    private LottoGame lottoGame;

    @Test
    void lotto_able_to_buy_test(){
        assertThatThrownBy(()-> lottoGame = new LottoGame(900,1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또를 살 수 없습니다.");
    }

    @Test
    void lotto_count_test(){
        lottoGame = new LottoGame(17600,1);
        assertThat(lottoGame.getLottoCount()).isEqualTo(17);
    }

}