package lotto;

import lotto.controller.LottoMarket;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.RandomLottoGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static lotto.LottoNumberTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 상점 판매 테스트")
public class LottoMarketTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1"}, delimiter = ':')
    @DisplayName("지불한 금액만큼 로또를 구매한다. 1000원당 1개")
    void buyLottoTest(int money, int count) {
        List<Lottos> lottos = LottoMarket.buyLottos(new Money(money), new RandomLottoGenerator());

        assertThat(lottos).hasSize(count);
    }

    @Test
    @DisplayName("로또 구입시 지불한 금액이 null이면 예외가 발생한다.")
    void minusMoneyTest() {
        assertThatThrownBy(() -> LottoMarket.buyLottos(null, new RandomLottoGenerator()))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("구매한 로또와 당첨 로또를 입력해 통계를 계산할 때 입력값이 null이면 예외가 발생한다.")
    void getLottoStatisticNullTest() {
        assertThatThrownBy(() -> LottoMarket.getLottoStatistics(null, LottosTest.TEST_LOTTO))
                .isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> LottoMarket.getLottoStatistics(Lists.newArrayList(LottosTest.TEST_LOTTO), null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("구매한 로또와 당첨 로또를 입력하면 통계를 계산할 수 있다.")
    void getLottoStatisticTest() {
        LottoNumber ten = new LottoNumber(10);
        LottoNumber eleven = new LottoNumber(11);
        LottoNumber twelve = new LottoNumber(12);
        // given
        Lottos winnerLottos = WinnerLottosTest.WINNER_LOTTOS.getLottos();
        Lottos threeMatchLottos = new Lottos(Lists.newArrayList(ONE, TWO, THREE, ten, eleven, twelve));
        Lottos fourMatchLottos = new Lottos(Lists.newArrayList(ONE, TWO, THREE, FOUR, eleven, twelve));
        Lottos fiveMatchLottos = new Lottos(Lists.newArrayList(ONE, TWO, THREE, FOUR, FIVE, twelve));
        Lottos sixMatchLottos = new Lottos(Lists.newArrayList(ONE, TWO, THREE, FOUR, FIVE, SIX));

        // when
        Map<Integer, Integer> lottoStatistics = LottoMarket.getLottoStatistics(Lists.newArrayList(threeMatchLottos, fourMatchLottos, fiveMatchLottos, sixMatchLottos), winnerLottos);

        // then
        assertThat(lottoStatistics.get(3)).isEqualTo(1);
        assertThat(lottoStatistics.get(4)).isEqualTo(1);
        assertThat(lottoStatistics.get(5)).isEqualTo(1);
        assertThat(lottoStatistics.get(6)).isEqualTo(1);
    }
}
