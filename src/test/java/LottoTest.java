import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 번호는 1 ~ 46사이의 번호를 가지고 있다.")
    @MethodSource("provideException")
    @ParameterizedTest
    void number(int input) {
        assertThatThrownBy(() ->
            new LottoNumber(input)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 숫자는 1 ~ 46 사이입니다.");
    }

    private static Stream<Arguments> provideException() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(47),
            Arguments.of(-1)
        );
    }

    @DisplayName("로또 숫자 1 ~ 46개 중 랜덤으로 6개 추출한다.")
    @Test
    void construct() {
        List<LottoNumber> selectedNumber = LottoNumbers.select();
        assertThat(selectedNumber.size()).isEqualTo(6);
        assertThat(lottoNumbers()).containsAll(selectedNumber);
    }

    @DisplayName("로또 번호는 6개여야 한다.")
    @MethodSource("provideSix")
    @ParameterizedTest
    void six(int input) {
        List<LottoNumber> numbers = generateByCount(input);

        assertThatThrownBy(() ->
            new Lotto(numbers)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호가 6개가 아닙니다.");
    }

    private static Stream<Arguments> provideSix() {
        return Stream.of(
            Arguments.of(5),
            Arguments.of(7)
        );
    }

    @DisplayName("로또 번호가 같은 경우 카운트")
    @MethodSource("provideLotto")
    @ParameterizedTest
    void lotto(Integer[] first, Integer[] second, int expected) {
        Lotto firstLotto = generateByNumbers(first);
        Lotto secondLotto = generateByNumbers(second);
        int actual = firstLotto.compare(secondLotto);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLotto() {
        return Stream.of(
            Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6}, new Integer[]{1, 2, 3, 4, 5, 6}, 6),
            Arguments.of(new Integer[]{1, 4, 6, 36, 37, 46}, new Integer[]{1, 2, 3, 4, 5, 6}, 3)
        );
    }

    private Lotto generateByNumbers(Integer[] lottoNumbers) {
        return new Lotto(Arrays.stream(lottoNumbers)
            .map(LottoNumber::new)
            .collect(toList()));
    }

    private List<LottoNumber> generateByCount(int input) {
        List<LottoNumber> numbers = new ArrayList();
        for (int i = 1; i <= input; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    private List<LottoNumber> lottoNumbers() {
        return generateByCount(46);
    }
}
