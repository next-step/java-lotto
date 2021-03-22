package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("로또 난수 6개 생성")
    @ParameterizedTest
    @ValueSource(ints = {6, 6, 6})
    void getSixLottoNumbers(int expected) {
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        int[] lottoArray = lottoGenerator.generateShuffledNumbers();
        assertThat(lottoArray.length).isEqualTo(expected);
    }
}
