package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Fixture.lottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;


class LottoManualGeneratorTest {

    @DisplayName("로또 입력 생성 테스트")
    @Test
    void testInputCreateLotto() {
        List<String> inputText = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<LottoNumber> expected = lottoNumbers();

        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator(inputText);
        List<LottoNumber> actual = lottoManualGenerator.generateNumbers();

        assertThat(expected).isEqualTo(actual);
    }

}
