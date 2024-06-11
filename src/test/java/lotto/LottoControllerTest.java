package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {
    @Test
    @DisplayName("입력한 금액으로 구매할 수 있는 최대 개수 만큼 로또를 구매한다")
    void buyLotto() {
        int money = 10000;
        LottoController lottoController = new LottoController();

        lottoController.buy(money);

        assertThat(lottoController.getLottos().size()).isEqualTo(money / Lotto.PRICE);
    }

//    @Test
//    @DisplayName("당첨 로또의 번호를 보고 로또 게임 결과를 확인한다.")
//    void playLotto() {
//        // given
//        List<Lotto> lottos = List.of(new Lotto(Set.of(8, 21, 23, 41, 42, 43)));
//        LottoController lottoController = new LottoController(lottos);
//        Set<Integer> winningNumbers = Set.of(8, 21, 23, 41, 42, 43);
//        int bonus = 1;
//
//        // when
//        LottoGameResult result = lottoController.play(winningNumbers, bonus);
//
//        // then
//        assertThat(result.getFirst()).isEqualTo(1);
//        assertThat(result.getSecond()).isEqualTo(0);
//        assertThat(result.getThird()).isEqualTo(0);
//        assertThat(result.getFourth()).isEqualTo(0);
//        assertThat(result.getFifth()).isEqualTo(0);
//        assertThat(result.getProfitRatio()).isEqualTo(((double) 2000000000L) / Lotto.PRICE);
//    }
}