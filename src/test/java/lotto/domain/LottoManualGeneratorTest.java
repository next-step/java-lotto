package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class LottoManualGeneratorTest {
    private List<LottoNumber> expected;

    @BeforeEach
    void setUp() {
        expected = lottoNumbers();
    }

    @DisplayName("로또 입력 생성 테스트")
    @Test
    void testInputCreateLotto() {
        List<LottoNumber> inputLottos = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            inputLottos.add(new LottoNumber(i));
        }
        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator(inputLottos);

        List<LottoNumber> actual = lottoManualGenerator.generateNumbers();

        assertThat(expected).isEqualTo(actual);
    }

    private List<LottoNumber> lottoNumbers() {
        List<Integer> sixNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        return sixNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

}
