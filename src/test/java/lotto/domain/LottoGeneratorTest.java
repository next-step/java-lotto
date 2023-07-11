package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(strings = {"10000", "9999", "100000"})
    @DisplayName("받은 금액만큼 로또를 생성하는지 테스트")
    void lottoGenerator_amountToLotto(final String value) {
        /* given */
        final Money money = new Money(value);

        /* when */
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> boughtLottos = lottoGenerator.generate(money);

        /* then */
        assertThat(boughtLottos).hasSize(Integer.parseInt(value) / 1000);
    }
}
