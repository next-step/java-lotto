package lotto.step2.util;

import lotto.step2.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProgramManagerTest {
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

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    @DisplayName("발급할 수량을 입력하면, 해당 개수만큼의 로또 List를 발급한다.")
    void testGenerateLottos(final int numberOfLottos) {
        //given
        //when
        final List<Lotto> lottos = LottoProgramManager.generateLottos(numberOfLottos);

        //then
        assertThat(lottos).hasSize(numberOfLottos);
    }
}
