package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.model.domain.RandomNumbersGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoServiceTest {

    @Test
    void 로또_서비스_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new LottoService(1000, RandomNumbersGenerator.getInstance()));
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,14", "14001,14", "1000,1"})
    void 로또_서비스_구입금액에_해당하는_로또_생성_성공(int money, int expectedSize) {
        // when
        LottoService lottoService = new LottoService(money, RandomNumbersGenerator.getInstance());

        // then
        assertThat(lottoService.getLottos().getLottos()).hasSize(expectedSize);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,0", "14001,1", "1000,0", "1500,500"})
    void 로또_서비스_구입금액에_해당하는_거스름돈_생성_성공(int money, int expectedChange) {
        // when
        LottoService lottoService = new LottoService(money, RandomNumbersGenerator.getInstance());

        // then
        assertThat(lottoService.getChange()).isEqualTo(expectedChange);
    }
}
