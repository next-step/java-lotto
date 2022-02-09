package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    private static final int PRICE_OF_LOTTO = 1000;

    @DisplayName("구매할 수 있는 개수 만큼 로또가 구매된다.")
    @ValueSource(strings = {"10000", "14500"})
    @ParameterizedTest
    void Given_구매_금액_When_로또자동_생성_Then_구매금액에_맞게_생성(final String budget) {
        // given
        final int numberOfLotto = Integer.parseInt(budget) / PRICE_OF_LOTTO;

        // when
        final Lottos autoLottos = Lottos.createAutoLottos(new Budget(budget));

        // then
        assertThat(autoLottos.getNumberOfPurchases()).isEqualTo(numberOfLotto);
    }
}
