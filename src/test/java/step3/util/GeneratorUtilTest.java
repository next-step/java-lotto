package step3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GeneratorUtilTest {

    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("생성기의 숫자생성기는 1이상의 숫자를 입력받아야한다.")
    void checkInputNumber(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> GeneratorUtil.createNumbersFromOne(input));
    }

    @Test
    @DisplayName("생성기는 1부터 45까지의 숫자를 생성할 수 있다.")
    void createNumbers() {
        List<Integer> numbers = GeneratorUtil.createNumbersFromOne(LOTTO_LAST_NUMBER);
        assertThat(numbers).hasSize(LOTTO_LAST_NUMBER);
    }

    @Test
    @DisplayName("생성기는 입력받은 숫자목록을 섞은 후 앞 6개를 반환한다.")
    void createLottoNumbers() {
        List<Integer> lottoNumbers = GeneratorUtil.randomNumbers(LOTTO_LAST_NUMBER, LOTTO_SIZE);
        assertThat(lottoNumbers).hasSize(LOTTO_SIZE);
    }
}
