package step2.domain.lotto;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,2,2,5,6", "1,2,3,4,5,6,7,8", "-1,2,3,4,5,6", "1,2,3,4,5,46"})
    @DisplayName("로또 번호 검증 실패 테스트")
    void lottoNumberCheckingFailTest(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers(numbers));
    }

    @Test
    @DisplayName("로또 번호 검증 테스트")
    void lottoNumberCheckingTest() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 10, 20, 30, 40, 45));
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }
}
