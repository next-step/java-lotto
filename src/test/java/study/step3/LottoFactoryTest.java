package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step3.domain.Amount;
import study.step3.domain.LottoFactory;
import study.step3.domain.Lottos;

public class LottoFactoryTest {

    @ParameterizedTest(name = "구입 테스트")
    @CsvSource(value = {"2000:2", "3000:3", "12000:12"}, delimiter = ':')
    public void purchase(int input, int expected) {
        // given
        Lottos lottos = LottoFactory.purchase(new Amount(input));
        // when & then
        assertThat(lottos.getLottos().size()).isEqualTo(expected);
    }
}


