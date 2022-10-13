package lotto;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.Lotto;
import lotto.service.LottoFactory;

public class LottoFactoryTest {
    LottoFactory lottoFactory;

    @BeforeEach
    public void init() {
        lottoFactory = new LottoFactory(new Calculator());
    }

    @ParameterizedTest
    @CsvSource(value = { "14000 : 14", "17000 : 17", "15400 : 15" }, delimiter = ':')
    public void generate_lotto_test(BigDecimal payAmount, int expectSize) {
        Lotto lotto = lottoFactory.generateLotto(payAmount);
        assertThat(lotto.getLottoSize()).isEqualTo(expectSize);
    }
}
