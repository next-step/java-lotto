package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 45;

    private List<String> splitString(String input) {
        return Arrays.stream(input.split(","))
            .collect(Collectors.toList());
    }

    private static Stream<Arguments> 유효한_당첨번호_입력_시_통과() {
        return Stream.of(
            Arguments.of(Arrays.asList("1", "2", "3", "4", "5", "6")),
            Arguments.of(Arrays.asList("2", "34", "5", "23", "18", "9"))
        );
    }

    @ParameterizedTest
    @MethodSource
    void 유효한_당첨번호_입력_시_통과(List<String> inputNumbers) {
        List<Integer> lottoNumbers = new Lotto(inputNumbers).getLotto();
        List<String> numbers = lottoNumbers.stream()
            .map(number -> Integer.toString(number))
            .collect(Collectors.toList());
        assertThat(numbers).isEqualTo(inputNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,100,2,3,4,5,6", "234,35,2,4,5,7"})
    void 범위를_초과하는_숫자가_있는_경우(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(splitString(input))).withMessage(
                "[ERROR] " + MINIMUM_BALL_NUMBER + "부터 " + MAXIMUM_BALL_NUMBER + "까지의 숫자만 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "7,35,2,4,5,7"})
    void 중복되는_숫자가_있는_경우(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(splitString(input)))
            .withMessage("[ERROR] 중복되는 숫자가 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,5,6", "4,23,1,45,3,19,20"})
    void 로또의_유효한_크기를_충족하지_않는_경우(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(splitString(input)))
            .withMessage("[ERROR] 번호는 " + LOTTO_NUMBERS_SIZE + "개여야 합니다.");
    }

}
