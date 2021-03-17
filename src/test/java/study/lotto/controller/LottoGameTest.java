package study.lotto.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.Lotto;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @ParameterizedTest(name = "{0} 금액 입력 시 로또 {1} 세트 출력 테스트")
    @CsvSource(value = {"1000, 1", "2000, 2"})
    void buyLotto_금액_지불_및_로또_반환(int given, int expected) {
        // given
        LottoGame lottoGame = new LottoGame();
        // when
        Lottos lottos = lottoGame.buyLotto(new RequestMoney(given));
        List<Lotto> lotteries = lottos.getLotteries();
        // then
        assertThat(lotteries.size()).isEqualTo(expected);
    }
}
