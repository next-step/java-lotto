package lotto2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto2.domain.Fixture.lottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;


class LottoManualGeneratorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void testInputCreateLotto(final String inputText) {
        List<LottoNumber> expected = lottoNumbers();

        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator(inputText);
        List<LottoNumber> actual = lottoManualGenerator.generateNumbers();

        assertThat(expected).isEqualTo(actual);
    }

}
