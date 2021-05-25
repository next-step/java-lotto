package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("구입 금액과 수동 로또 번호들을 입력하면 수동, 자동 로또들을 구매한다")
    @ParameterizedTest
    @CsvSource(value = {"14000,3,14", "5000,2,5"})
    void buy_lotto(int amount, int countOfManualLotto, int expectedCount) {
        // given
        LottoGame lottoGame = LottoGame.init(amount);
        List<List<Integer>> manualLottoes = new ArrayList<>();
        for (int i = 0; i < countOfManualLotto; i++) {
            manualLottoes.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        }

        // when
        lottoGame.buyLotto(new TestLottoNumberGenerator(), manualLottoes);
        Lottoes lottoes = lottoGame.getLottoes();

        // then
        assertThat(lottoes.getLottoCount()).isEqualTo(expectedCount);
    }
}
