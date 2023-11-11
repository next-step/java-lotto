package lotto.step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProgramTest {
    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 5000, 10000, 14000})
    @DisplayName("구입금액 가격이 입력되면, 로또 몇장을 구매할 수 있는지 반환한다.")
    void testCalculateNumberOfLottoTickets(final int purchaseAmount) {
        //given
        final int lottoPrice = LottoProgram.LOTTO_PRICE;

        //when
        int actualNumberOfLottos = LottoProgramManager.calculateNumberOfLottos(purchaseAmount, lottoPrice);

        //then
        assertThat(actualNumberOfLottos).isEqualTo(purchaseAmount / lottoPrice);
    }
}
