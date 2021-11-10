package lotto.domain;

import lotto.service.RandomLottoNumberGenerateStrategy;
import lotto.vo.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = LottoGenerator.create(new RandomLottoNumberGenerateStrategy());
    }

    @DisplayName("generateLotto(int count) count 만큼 로또를 생성해서 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void generateTest(int count) {
        Lottos lottos = lottoGenerator.generateLotto(count);

        assertThat(lottos.count()).isEqualTo(count);
    }

}
