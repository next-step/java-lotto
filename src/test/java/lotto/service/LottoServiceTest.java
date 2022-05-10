package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"200000:1000:200", "200123:1000:200", "500:1000:0"}, delimiter = ':')
    void generateRandomLottosTest(int totalPrice, int eachPrice) {
        LottoService lottoService = new LottoService();
        Lottos lottos = lottoService.generateRandomLottos(new TestGenerator(), totalPrice, eachPrice);
        assertThat(lottoService.generateRandomLottos(new TestGenerator(), totalPrice, eachPrice))
                .isEqualTo(lottos);
    }

    static class TestGenerator implements GenerateNumberStrategy {
        private static int count = 1;

        @Override
        public int generate() {
            return count++ % 45 + 1;
        }
    }
}
