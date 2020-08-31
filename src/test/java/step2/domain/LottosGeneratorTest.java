package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.LottosGenerator.getAutoLottos;
import static step2.domain.LottosGenerator.getManualLottos;

class LottosGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"6:6"}, delimiter = ':')
    public void 로또_자동생성(int count, int size) {
        assertThat(getAutoLottos(count).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1"}, delimiter = ':')
    public void 로또_수동생성(String inputNumber, int size) {
        List<String> inputNumbers = Arrays.asList(inputNumber);
        assertThat(getManualLottos(inputNumbers).size()).isEqualTo(size);
    }
}