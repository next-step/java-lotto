package step2.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.vo.Money;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosIssuanceTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "5500:5", "12000:12"}, delimiter = ':')
    void 로또_발급(int money, int quantity) {
        final var lottos = LottosIssuance.issues(new ArrayList<>(), new Money(money));

        final var lottoList = lottos.getLottos();

        assertThat(lottoList).hasSize(quantity);
    }
}
