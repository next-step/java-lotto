package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class LottoGeneratorTest {

    @DisplayName("요청한 개수 만큼 로또 번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 6})
    public void generatorTest(int count) {
        LottoGenerator lottoGenerator = LottoGenerator.newInstance();

        List<Lotto> lottos = lottoGenerator.generator(count);

        Assertions.assertThat(lottos.size()).isEqualTo(count);
    }
}
