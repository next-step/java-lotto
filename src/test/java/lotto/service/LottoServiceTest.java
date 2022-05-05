package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.RandomNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"200000:1000:200", "200123:1000:200", "500:1000:0"}, delimiter = ':')
    void generateRandomLottosTest(int totalPrice, int eachPrice, int resultCount) {
        LottoService lottoService = new LottoService();
        Lottos lottos = lottoService.generateRandomLottos(new RandomNumberGenerator(), totalPrice, eachPrice);
        List<Lotto> lottoList = (List< Lotto >) ReflectionTestUtils.getField(lottos, "lottos");

        assertThat(lottoList.size()).isEqualTo(resultCount);
    }
}