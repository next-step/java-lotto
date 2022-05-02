package lottoauto.service;

import lottoauto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LottoGameTest {
    LottoGame lottoGame;

    @Test
    void lotto_able_to_buy_test(){
        assertThatThrownBy(()-> lottoGame = new LottoGame(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또를 살 수 없습니다.");
    }

    @Test
    void lotto_count_test(){
        lottoGame = new LottoGame(17600);
        assertThat(lottoGame.getLottoCount()).isEqualTo(17);
    }

    @Test
    void lotto_generate_test(){
        lottoGame = new LottoGame(17600);
        lottoGame.checkWinningLotto(new Lotto(List.of(1,2,3,4,5,6), 7));
        lottoGame.buyLotto();
        assertThat(lottoGame.all().size()).isEqualTo(17);
    }
}