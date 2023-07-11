package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    void 로또_서비스_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new LottoService(0));
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,14", "14001,14", "1000,1"})
    void 로또_서비스_구입금액에_해당하는_로또_생성_성공(int money, int expectedSize) {
        // when
        LottoService lottoService = new LottoService(money);

        // then
        assertThat(lottoService.getLottos().getLottos()).hasSize(expectedSize);
    }
}
