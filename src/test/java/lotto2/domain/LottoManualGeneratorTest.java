package lotto2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class LottoManualGeneratorTest {
    private List<Integer> sixNumbers;

    @BeforeEach
    void setUp() {
        sixNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void testInputCreateLotto(final String inputText) {
        List<LottoNumber> mock = sixNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Set<LottoNumber> expected = new Lotto(mock).getLottoNumbers();

        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator(inputText);
        Set<LottoNumber> actual = lottoManualGenerator.generateNumbers();

        assertThat(expected).isEqualTo(actual);
    }

}
