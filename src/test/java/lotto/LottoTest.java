package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 구매금액만큼_로또를_최대치_구입한다() {
        int lottoPrice = 1000;
        int purchaseBudget = 14000;

        LottoGame lottoGame = new LottoGame(lottoPrice, purchaseBudget);
        assertThat(lottoGame.hasLottoCount()).isEqualTo(purchaseBudget / lottoPrice);
    }

    @Test
    void 몇개_맞았는지_계산해주기() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto( List.of(1, 2, 3, 7, 8, 9));

        int matchedCount = winLotto.countMatchedNumber(myLotto);

        assertThat(matchedCount).isEqualTo(3);
    }

    /**
     * 수익률 = 총 당첨 금액 / 구입 금액
     */
    @Test
    void statistics_on_matched_count() {
        long purchaseBudget = 1000L;
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        /**
         * 내 로또 어떻게 만들거임?
         * 테스트 가능하도록 내 로또를 만들어내는 것이 핵심
         */
        LottoGame lottoGame = new LottoGame(List.of(
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        ));
        double rate = lottoGame.produceStatistics(purchaseBudget, winLotto);

        assertThat(rate).isEqualTo(5);
    }
}