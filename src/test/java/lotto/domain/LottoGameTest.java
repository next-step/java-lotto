package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("구입금액을 입력하면 천원당 1장씩 로또를 구매한다")
    @ParameterizedTest
    @CsvSource(value = {"14000,14", "5000,5"})
    void buy_lotto(int amount, int expectedCount) {
        // given
        LottoGame lottoGame = LottoGame.init(amount);

        // when
        lottoGame.buyLotto(new TestLottoNumberGenerator());

        // then
        assertThat(lottoGame.getLottoes().size()).isEqualTo(expectedCount);
    }
}