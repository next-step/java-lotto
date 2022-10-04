package lotto;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoFactoryTest {
    LottoFactory lottoFactory;

    @BeforeEach
    public void init() {
        lottoFactory = new LottoFactory();
    }

    @ParameterizedTest
    @CsvSource(value = { "14000 : 14", "17000 : 17", "15400 : 15" }, delimiter = ':')
    public void generate_lotto_test(BigDecimal payAmount, int expectSize) {
        List<Lotto> lotto = lottoFactory.generateLotto(payAmount);
        assertThat(lotto.size()).isEqualTo(expectSize);
    }
}
