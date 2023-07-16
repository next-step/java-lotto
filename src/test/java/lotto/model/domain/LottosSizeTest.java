package lotto.model.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LottosSizeTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "5001,3", "14001,0"})
    void 로또_개수_생성_성공(long totalMoney, long manualSize) {
        // given
        final LottoMoney totalLottoMoney = LottoMoney.valueOf(totalMoney);

        // when & then
        assertThatNoException().isThrownBy(() -> LottosSize.of(totalLottoMoney, manualSize));
    }
}
