package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {

    @Test
    void 생성자테스트() throws Exception {
        LottoCalculator lottoCalculator = new LottoCalculator(new Money(14000));
        assertThat(lottoCalculator.getLottos().size()).isEqualTo(14);
    }
}
