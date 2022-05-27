package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"200000:200", "200123:200", "500:0"}, delimiter = ':')
    void generateRandomLottosTest(int totalPrice, int count) {
        LottoService lottoService = new LottoService();
        assertThat(lottoService.generateRandomLottos(new TestGenerator(), new Money(totalPrice)).size())
                .isEqualTo(count);
    }

    @Test
    void generateManualLottosTest() {
        LottoService lottoService = new LottoService();
        List<String> lottoList = new ArrayList<>();
        lottoList.add("8, 21, 23, 41, 42, 43");
        lottoList.add("3, 5, 11, 16, 32, 38");
        lottoList.add("7, 11, 16, 35, 36, 44");

        assertThat(lottoService.generateManualLottos(lottoList).size())
                .isEqualTo(3);
    }

    static class TestGenerator implements GenerateNumberStrategy {
        private static int count = 1;

        @Override
        public int generate() {
            return count++ % 45 + 1;
        }
    }
}
